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
simulctl> "QUERY INPUT"
+--------------+
| Query Result |
+--------------+
| Query Result |
+--------------+
00 row in set (0.00 sec)
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