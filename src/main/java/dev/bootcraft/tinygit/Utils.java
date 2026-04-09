package dev.bootcraft.tinygit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * 底层工具类（已实现，直接使用即可）。
 * <p>
 * 提供 SHA-1 哈希、zlib 压缩/解压、对象路径计算等底层操作，
 * 让你专注于 Git 核心逻辑而非密码学和压缩算法的 API 细节。
 */
public final class Utils {

    private Utils() {}

    /**
     * 计算数据的 SHA-1 哈希值，返回 40 位十六进制字符串。
     *
     * <pre>
     * sha1Hash("blob 5\0hello".getBytes()) → "b6fc4c620b67d95f953a5c1c1230aaab5db5a1b0"
     * </pre>
     */
    public static String sha1Hash(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(data);
            StringBuilder sb = new StringBuilder(40);
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据 SHA-1 哈希值返回 .git/objects 下的存储路径。
     * <p>
     * Git 以哈希前 2 位为目录名，后 38 位为文件名：
     * <pre>
     * objectPath(".git", "ce013625...") → ".git/objects/ce/013625..."
     * </pre>
     */
    public static Path objectPath(String gitDir, String sha) {
        return Path.of(gitDir, "objects", sha.substring(0, 2), sha.substring(2));
    }

    /**
     * zlib 压缩。Git 对象以 zlib 压缩后写入磁盘。
     */
    public static byte[] zlibCompress(byte[] data) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (DeflaterOutputStream deflater = new DeflaterOutputStream(out)) {
            deflater.write(data);
        }
        return out.toByteArray();
    }

    /**
     * zlib 解压。读取 Git 对象时先解压再解析。
     */
    public static byte[] zlibDecompress(byte[] data) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        try (InflaterInputStream inflater = new InflaterInputStream(in)) {
            return inflater.readAllBytes();
        }
    }
}
