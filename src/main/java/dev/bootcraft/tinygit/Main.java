package dev.bootcraft.tinygit;

/**
 * tinygit — 教学版 Git 的 CLI 入口。
 * <p>
 * 用法: java dev.bootcraft.tinygit.Main &lt;command&gt; [&lt;args&gt;...]
 * <p>
 * 按 stage 顺序逐步取消注释 / 实现各个子命令。
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: tinygit <command> [<args>...]");
            System.exit(1);
        }

        String command = args[0];

        switch (command) {

            // ================================================================
            // S01: 初始化仓库
            // ================================================================
            case "init" -> cmdInit();

            // ================================================================
            // S02: 读取 Blob 对象
            // ================================================================
            case "cat-file" -> cmdCatFile(args);

            // ================================================================
            // S03: 写入 Blob 对象
            // ================================================================
            case "hash-object" -> cmdHashObject(args);

            // ================================================================
            // S04: 读取 Tree 对象
            // ================================================================
            case "ls-tree" -> cmdLsTree(args);

            // ================================================================
            // S05: 写入 Tree 对象
            // ================================================================
            case "write-tree" -> cmdWriteTree(args);

            // ================================================================
            // S06: 暂存区与 add
            // ================================================================
            case "add" -> cmdAdd(args);

            // ================================================================
            // S07: 创建提交
            // ================================================================
            case "commit" -> cmdCommit(args);

            // ================================================================
            // S08: 提交历史
            // ================================================================
            case "log" -> cmdLog(args);

            // ================================================================
            // S09: 工作区状态
            // ================================================================
            case "status" -> cmdStatus(args);

            // ================================================================
            // S10: 分支与切换
            // ================================================================
            case "branch" -> cmdBranch(args);
            case "checkout" -> cmdCheckout(args);

            // ================================================================
            // S11: 差异比较
            // ================================================================
            case "diff" -> cmdDiff(args);

            // ================================================================
            // S12: 三方合并
            // ================================================================
            case "merge" -> cmdMerge(args);

            default -> {
                System.err.printf("tinygit: '%s' is not a tinygit command.%n", command);
                System.exit(1);
            }
        }
    }

    // ─── S01: 初始化仓库 ─────────────────────────────────────────

    private static void cmdInit() {
        // TODO: 取消下方注释即可通过 Stage 1
        //
        // try {
        //     java.nio.file.Files.createDirectory(java.nio.file.Path.of(".git"));
        //     java.nio.file.Files.createDirectory(java.nio.file.Path.of(".git", "objects"));
        //     java.nio.file.Files.createDirectory(java.nio.file.Path.of(".git", "refs"));
        //     java.nio.file.Files.createDirectories(java.nio.file.Path.of(".git", "refs", "heads"));
        //     java.nio.file.Files.writeString(java.nio.file.Path.of(".git", "HEAD"), "ref: refs/heads/main\n");
        //     System.out.println("Initialized git directory");
        // } catch (java.io.IOException e) {
        //     throw new RuntimeException(e);
        // }
    }

    // ─── S02: 读取 Blob 对象 ─────────────────────────────────────

    private static void cmdCatFile(String[] args) {
        throw new UnsupportedOperationException("TODO: S02 — cat-file -p <hash>");
    }

    // ─── S03: 写入 Blob 对象 ─────────────────────────────────────

    private static void cmdHashObject(String[] args) {
        throw new UnsupportedOperationException("TODO: S03 — hash-object -w <file>");
    }

    // ─── S04: 读取 Tree 对象 ─────────────────────────────────────

    private static void cmdLsTree(String[] args) {
        throw new UnsupportedOperationException("TODO: S04 — ls-tree --name-only <hash>");
    }

    // ─── S05: 写入 Tree 对象 ─────────────────────────────────────

    private static void cmdWriteTree(String[] args) {
        throw new UnsupportedOperationException("TODO: S05 — write-tree");
    }

    // ─── S06: 暂存区与 add ───────────────────────────────────────

    private static void cmdAdd(String[] args) {
        throw new UnsupportedOperationException("TODO: S06 — add <file>...");
    }

    // ─── S07: 创建提交 ───────────────────────────────────────────

    private static void cmdCommit(String[] args) {
        throw new UnsupportedOperationException("TODO: S07 — commit -m <message>");
    }

    // ─── S08: 提交历史 ───────────────────────────────────────────

    private static void cmdLog(String[] args) {
        throw new UnsupportedOperationException("TODO: S08 — log");
    }

    // ─── S09: 工作区状态 ─────────────────────────────────────────

    private static void cmdStatus(String[] args) {
        throw new UnsupportedOperationException("TODO: S09 — status");
    }

    // ─── S10: 分支与切换 ─────────────────────────────────────────

    private static void cmdBranch(String[] args) {
        throw new UnsupportedOperationException("TODO: S10 — branch <name>");
    }

    private static void cmdCheckout(String[] args) {
        throw new UnsupportedOperationException("TODO: S10 — checkout <name>");
    }

    // ─── S11: 差异比较 ───────────────────────────────────────────

    private static void cmdDiff(String[] args) {
        throw new UnsupportedOperationException("TODO: S11 — diff");
    }

    // ─── S12: 三方合并 ───────────────────────────────────────────

    private static void cmdMerge(String[] args) {
        throw new UnsupportedOperationException("TODO: S12 — merge <branch>");
    }
}
