package io.cdap.wrangler.utils;

public class ByteSizeParser {

    public static long parseByteSize(String size) {
        size = size.trim().toUpperCase();

        if (size.endsWith("KB")) {
            return Long.parseLong(size.replace("KB", "").trim()) * 1024;
        } else if (size.endsWith("MB")) {
            return Long.parseLong(size.replace("MB", "").trim()) * 1024 * 1024;
        } else if (size.endsWith("GB")) {
            return Long.parseLong(size.replace("GB", "").trim()) * 1024 * 1024 * 1024;
        } else if (size.endsWith("B")) {
            return Long.parseLong(size.replace("B", "").trim());
        } else {
            throw new IllegalArgumentException("Invalid byte size format: " + size);
        }
    }
}
