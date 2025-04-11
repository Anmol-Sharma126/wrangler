New Features: Byte Size and Time Duration Parsers
This update enhances Wrangler with built-in support for parsing Byte Sizes and Time Durations, enabling more expressive and simplified data wrangling.

✅ Supported Units
Byte Sizes (case-insensitive):
B (Bytes)

KB / K (Kilobytes)

MB / M (Megabytes)

GB / G (Gigabytes)

TB / T (Terabytes)

Example values: 512B, 1KB, 1.5MB, 2G, 3.75tb

Time Durations:
ms (Milliseconds)

s (Seconds)

m (Minutes)

h (Hours)

d (Days)

Example values: 100ms, 2s, 1.5m, 3h, 1d

🧠 How It Works
These units can now be parsed as token types inside recipes, and used with directives like aggregate-stats for smart aggregation based on size and time.

📊 New Directive: aggregate-stats
This directive performs aggregation on two columns: one for byte size, and one for time duration. It outputs the total or average in desired units.

Syntax:
php-template
Copy
Edit
aggregate-stats :<byteSizeColumn> :<timeDurationColumn> <outputByteSizeColumn> <outputTimeDurationColumn> [<byteUnit>] [<timeUnit>] [<aggregationType>]
Arguments:
Position	Description
1	Source column containing byte sizes
2	Source column containing time durations
3	Output column name for total/average size
4	Output column name for total/average time
5 (optional)	Byte unit for output (e.g. MB, GB)
6 (optional)	Time unit for output (e.g. s, ms)
7 (optional)	Aggregation type: total (default), avg
🧪 Example
Given a dataset:

data_transfer_size	response_time
1MB	500ms
2MB	1.5s
Recipe:

wrangler
Copy
Edit
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec MB s total
Output:

total_size_mb	total_time_sec
3.0	2.0