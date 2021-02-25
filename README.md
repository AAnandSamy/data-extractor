# data-extractor

Slick is a modern database query and access library for Scala, Data extractor based on slick API.

- performance test on Postgres DB
  ```csv
  |Records   |Retrieval-time|
  |----------|--------------|
  |0 - 100   | 2 Seconds    |
  |0 - 1000  | 2 Seconds    |
  |0 - 10000 | 3 Seconds    |
  |0 - 100000| 4 Seconds    |
  |0 - 400000| 7 Seconds    |
  ```

- performance test on Oracle DB
