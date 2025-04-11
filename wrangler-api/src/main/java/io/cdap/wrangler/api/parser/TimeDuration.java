package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;

public class TimeDuration implements Token {
    private final long milliseconds;

    public TimeDuration(String value) {
        super();
        this.milliseconds = parseMilliseconds(value);
    }

    private long parseMilliseconds(String value) {
        String v = value.toLowerCase().trim();
        if (v.endsWith("ms")) return (long) Double.parseDouble(v.replace("ms", ""));
        if (v.endsWith("s"))  return (long) (Double.parseDouble(v.replace("s", "")) * 1000);
        if (v.endsWith("m"))  return (long) (Double.parseDouble(v.replace("m", "")) * 60 * 1000);
        if (v.endsWith("h"))  return (long) (Double.parseDouble(v.replace("h", "")) * 3600 * 1000);
        throw new IllegalArgumentException("Invalid time duration format: " + value);
    }

    public long getMilliseconds() {
        return milliseconds;
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
