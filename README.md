# TinyGit — Java

从零实现一个教学版 Git（Java 版）。

## 项目结构

```
src/main/java/cn/bootcraft/tinygit/
├── Main.java         ← CLI 入口 + 命令分发
└── Utils.java        ← 底层工具（SHA-1 / zlib / 对象路径）
```

## 快速开始

```bash
# 运行你的 TinyGit
./run.sh init

# 或手动编译运行
javac -d target src/main/java/cn/bootcraft/tinygit/*.java
java -cp target cn.bootcraft.tinygit.Main init
```

在 `Main.java` 中找到 `TODO` 注释，按 Stage 顺序逐步实现。

`Utils.java` 提供了 SHA-1 哈希、zlib 压缩/解压等底层工具方法，直接调用即可。

## 学术诚信

- ✅ 讨论问题思路
- ✅ 查阅官方文档
- ❌ 复制他人代码
- ❌ 分享完整答案
