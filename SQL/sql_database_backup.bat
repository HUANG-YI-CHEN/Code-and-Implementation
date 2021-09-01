echo off
net stop mssqlserver /y
set day=%date:~0,4%%date:~5,2%%date:~8,2%
xcopy D:\DB D:\Backup\DataBase\%day% /y /c /s /e /i
net start mssqlserver

xcopy D:\Backup\DataBase\%day% \\0.0.0.0\備份\Database\CSIE\%day% /y /c /s /e /i
xcopy E:\www \\0.0.0.0\備份\Portal\CSIE\%day%/y /c /s /e /i