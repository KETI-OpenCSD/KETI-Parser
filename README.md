# KETI-Parser

``` shell
$ simulctl run -n 8 --config csdconfig.conf
Boot Simulator...(1/8) pid:18659 appending output to 'csd1.out'
Boot Simulator...(2/8) pid:18750 appending output to 'csd2.out'
Boot Simulator...(3/8) pid:18787 appending output to 'csd3.out'
Boot Simulator...(4/8) pid:18824 appending output to 'csd4.out'
Boot Simulator...(5/8) pid:18843 appending output to 'csd5.out'
Boot Simulator...(6/8) pid:18873 appending output to 'csd6.out'
Boot Simulator...(7/8) pid:18898 appending output to 'csd7.out'
Boot Simulator...(8/8) pid:18938 appending output to 'csd8.out'
Boot Done!
simulctl> SELECT l_returnflag,
    ->        l_linestatus,
    ->        SUM(l_quantity)                                           AS sum_qty,
    ->        SUM(l_extendedprice)                                      AS
    ->        sum_base_price,
    ->        SUM(l_extendedprice * ( 1 - l_discount ))                 AS
    ->        sum_disc_price,
    ->        SUM(l_extendedprice * ( 1 - l_discount ) * ( 1 + l_tax )) AS sum_charge,
    ->        Avg(l_quantity)                                           AS avg_qty,
    ->        Avg(l_extendedprice)                                      AS avg_price,
    ->        Avg(l_discount)                                           AS avg_disc,
    ->        Count(*)                                                  AS count_order
    -> FROM   lineitem
    -> WHERE  l_shipdate <= DATE ('1998-12-01') - interval '108' day
    -> GROUP  BY l_returnflag,
    ->           l_linestatus
    -> ORDER  BY l_returnflag,
    ->           l_linestatus;
+--------------+--------------+------------+----------------+-----------------+-------------------+-----------+--------------+----------+-------------+
| l_returnflag | l_linestatus | sum_qty    | sum_base_price | sum_disc_price  | sum_charge        | avg_qty   | avg_price    | avg_disc | count_order |
+--------------+--------------+------------+----------------+-----------------+-------------------+-----------+--------------+----------+-------------+
| A            | F            |  629003.00 |   944406753.42 |  897065456.0326 |  933250082.544402 | 25.592115 | 38424.882147 | 0.050033 |       24578 |
| N            | F            |   15338.00 |    23376166.61 |   22283900.9680 |   23179095.721397 | 26.040747 | 39687.888981 | 0.047810 |         589 |
| N            | O            | 1225369.00 |  1836383998.71 | 1744820864.9817 | 1814761979.523119 | 25.434730 | 38117.441906 | 0.049927 |       48177 |
| R            | F            |  625965.00 |   937341012.60 |  890557362.4528 |  926312668.580582 | 25.535000 | 38236.967145 | 0.050164 |       24514 |
+--------------+--------------+------------+----------------+-----------------+-------------------+-----------+--------------+----------+-------------+
4 rows in set (1 min 59.36 sec)
simulctl> poweroff all
Power off Simulator...(1/8)
Power off Simulator...(2/8)
Power off Simulator...(3/8)
Power off Simulator...(4/8)
Power off Simulator...(5/8)
Power off Simulator...(6/8)
Power off Simulator...(7/8)
Power off Simulator...(8/8)
Bye!
```
