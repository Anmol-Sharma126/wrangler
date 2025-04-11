package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Token for parsing byte size values (e.g., "10KB", "5MB", "1GB").
 */
public class ByteSize implements Token {
    private static final Pattern PATTERN = Pattern.compile("(\\d+)([KMGTP]?B)", Pattern.CASE_INSENSITIVE);
    private final long bytes;

    public ByteSize(String value) {
        super();
        this.bytes = parseBytes(value);
    }

    private long parseBytes(String value) {
        Matcher matcher = PATTERN.matcher(value.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid byte size format: " + value);
        }

        long number = Long.parseLong(matcher.group(1));
        String unit = matcher.group(2).toUpperCase();

        switch (unit) {
            case "KB": return number * 1024L;
            case "MB": return number * 1024L * 1024L;
            case "GB": return number * 1024L * 1024L * 1024L;
            case "TB": return number * 1024L * 1024L * 1024L * 1024L;
            case "PB": return number * 1024L * 1024L * 1024L * 1024L * 1024L;
            case "B":  return number;
            default: throw new IllegalArgumentException("Unknown byte unit: " + unit);
        }
    }

    public long getBytes() {
        return bytes;
    }

    @Override
    public Object value() {
        return null;
    }

    @Override
    public TokenType type() {
        return null;
    }

    @Override
    public JsonElement toJson() {
        return null;
    }
}
