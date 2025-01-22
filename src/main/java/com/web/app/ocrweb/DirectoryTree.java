package com.web.app.ocrweb;
import java.io.File;

public class DirectoryTree {
    public static void main(String[] args) {
        // Đường dẫn tới thư mục cần liệt kê
        String rootDir = "/workspaces/JavaPyOCR/"; // Thay thế bằng đường dẫn thực tế

        File root = new File(rootDir);
        if (root.exists() && root.isDirectory()) {
            System.out.println(root.getName());
            listDirectory(root, 1);
        } else {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục hợp lệ.");
        }
    }

    // Phương thức liệt kê thư mục
    private static void listDirectory(File dir, int depth) {
        // Lấy danh sách các tệp và thư mục con
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                // In các ký tự thụt lề để tạo dạng cây
                for (int i = 0; i < depth; i++) {
                    System.out.print("    ");
                }

                // In tên tệp/thư mục
                System.out.println("|-- " + file.getName());

                // Nếu là thư mục, gọi đệ quy
                if (file.isDirectory()) {
                    listDirectory(file, depth + 1);
                }
            }
        }
    }
}
