@echo off
::=========================================================  get administrator ===========================================================
title get administrator
setlocal
set uac=~uac_permission_tmp_%random%
md "%SystemRoot%\system32\%uac%" 2>nul
if %errorlevel%==0 ( rd "%SystemRoot%\system32\%uac%" >nul 2>nul ) else (
    echo set uac = CreateObject^("Shell.Application"^)>"%temp%\%uac%.vbs"
    echo uac.ShellExecute "%~s0","","","runas",1 >>"%temp%\%uac%.vbs"
    echo WScript.Quit >>"%temp%\%uac%.vbs"
    "%temp%\%uac%.vbs" /f
    del /f /q "%temp%\%uac%.vbs" & exit
    pushd "%cd%"
    cd /d "%~dp0"
)
endlocal
::==================================================  MainMenu  ==========================================================================

setlocal EnableDelayedExpansion
set autoEnable=0

:MainMenu
cls
title  Microsoft Servies Enable
mode con cols=98 lines=30
color 0a

echo:
echo:
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|                       Windows 10 優化                         ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows 服務 【自動】 - 優化/還原                    ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows 服務 【手動】 - 優化/還原                    ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] 退出                                                 ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|                                                               ^|
echo                  ^|             相關問題回報  neil2013707@hotmail.com             ^|
echo                  ^|                                                               ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "

if errorlevel 3 goto :Exit
if errorlevel 2 goto :ManualServices
if errorlevel 1 goto :AotomaticServices

::========================================  AotomaticServices Menu  =======================================================================

:AotomaticServices
setlocal EnableDelayedExpansion
set autoEnable=1
cls
color 0a

echo:
echo:
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|                       Windows 10 優化 【自動】                ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows 服務 【優化】                                ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows 服務 【還原】                                ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] 返回主選單                                           ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "

if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :AotomaticServices_restore
if errorlevel 1 goto :AotomaticServices_execute

::=======================================  AotomaticServices Action  ========================================================================

:AotomaticServices_execute
call :SystemSuperfetch_execute
call :StartupDelayInMSec_execute
call :HybridBoot_execute
call :WaitToKillServiceTimeout_execute
call :DisallowAnimations_execute
call :CEIPEnable_execute
call :Superfetch_execute
call :HomeGroup_execute
call :WSearch_execute

echo                   _______________________________________________________________
call :DisplayMessage_02 System記憶體占用 已優化
call :DisplayMessage_02 資料夾開啟速度加快 已優化
call :DisplayMessage_02 "開啟快速啟動(Hybrid Boot)" 已優化
call :DisplayMessage_02 關機時強制關閉背景程式不等待 已優化
call :DisplayMessage_02 關閉不必要的視覺動畫效果 已優化
call :DisplayMessage_02 關閉客戶體驗改善計劃 已優化
call :DisplayMessage_02 "關閉 Superfetch" 已優化
call :DisplayMessage_02 "關閉 HomeGroup 家用群組" 已優化
call :DisplayMessage_02 禁用索引服務 已優化
echo                  ^|_______________________________________________________________^|

call :StartReload & goto :AotomaticServices

:AotomaticServices_restore
call :SystemSuperfetch_restore
call :StartupDelayInMSec_restore
call :HybridBoot_restore
call :WaitToKillServiceTimeout_restore
call :DisallowAnimations_restore
call :CEIPEnable_restore
call :Superfetch_restore
call :HomeGroup_restore
call :WSearch_restore

echo                   _______________________________________________________________
call :DisplayMessage_02 System記憶體占用 已還原
call :DisplayMessage_02 資料夾開啟速度加快 已還原
call :DisplayMessage_02 "開啟快速啟動(Hybrid Boot)" 已還原
call :DisplayMessage_02 關機時強制關閉背景程式不等待 已還原
call :DisplayMessage_02 關閉不必要的視覺動畫效果 已還原
call :DisplayMessage_02 關閉客戶體驗改善計劃 已還原
call :DisplayMessage_02 "關閉 Superfetch" 已還原
call :DisplayMessage_02 "關閉 HomeGroup 家用群組" 已還原
call :DisplayMessage_02 禁用索引服務 已還原
echo                  ^|_______________________________________________________________^|

call :StartReload & goto :AotomaticServices

::=======================================  ManualServices Action  ======================================================================

:ManualServices
setlocal EnableDelayedExpansion
set autoEnable=0
cls
color 0a

echo:
echo:
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|                       Windows 10 手動優化                     ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows 服務 - System記憶體占用                      ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows 服務 - 資料夾開啟速度加快                    ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] Windows 服務 - 開啟快速啟動(Hybrid Boot)             ^|
echo                  ^|                                                               ^|
echo                  ^|      [4] Windows 服務 - 關機時強制關閉背景程式不等待          ^|
echo                  ^|                                                               ^|
echo                  ^|      [5] Windows 服務 - 關閉不必要的視覺動畫效果              ^|
echo                  ^|                                                               ^|
echo                  ^|      [6] Windows 服務 - 關閉客戶體驗改善計劃                  ^|
echo                  ^|                                                               ^|
echo                  ^|      [7] Windows 服務 - 關閉 Superfetch 服務                  ^|
echo                  ^|                                                               ^|
echo                  ^|      [8] Windows 服務 - 關閉 HomeGroup 家用群組               ^|
echo                  ^|                                                               ^|
echo                  ^|      [9] Windows 服務 - 禁用索引服務                          ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [M] 返回主選單  [N] 下一頁                               ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123456789MN /N /M ">                 在鍵盤上輸入你的選擇 [0,1,2,3,4,5,6,7,8,9,M,N] : "
echo %errorlevel%
pause
if errorlevel 11 goto :ManualServices02
if errorlevel 10 goto :MainMenu
if errorlevel 9 goto :WSearch
if errorlevel 8 goto :HomeGroup
if errorlevel 7 goto :Superfetch
if errorlevel 6 goto :CEIPEnable
if errorlevel 5 goto :DisallowAnimations
if errorlevel 4 goto :WaitToKillServiceTimeout
if errorlevel 3 goto :HybridBoot
if errorlevel 2 goto :StartupDelayInMSec
if errorlevel 1 goto :SystemSuperfetch

::=============================================  SystemSuperfetch Action  ==================================================================

:SystemSuperfetch
call :DisplayMessage_01 System記憶體占用
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :SystemSuperfetch_restore
if errorlevel 1 goto :SystemSuperfetch_execute

:SystemSuperfetch_execute
reg add "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Ndu" /v "Start" /d 4 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnablePrefetcher" /d 0 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnableSuperfetch" /d 0 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 System記憶體占用 已優化
call :StartReload & goto :SystemSuperfetch

:SystemSuperfetch_restore
reg add "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Ndu" /v "Start" /d 2 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnablePrefetcher" /d 3 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnableSuperfetch" /d 3 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 System記憶體占用 已還原
call :StartReload & goto :SystemSuperfetch

::=========================================  StartupDelayInMSec Action  ==================================================================

:StartupDelayInMSec
call :DisplayMessage_01 資料夾開啟速度加快
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :StartupDelayInMSec_restore
if errorlevel 1 goto :StartupDelayInMSec_execute

:StartupDelayInMSec_execute
reg add "HKEY_CURRENT_USER\Software\Microsoft \Windows\CurrentVersion\Explorer\Serialize" /v "StartupDelayInMSec" /d "0" /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 資料夾開啟速度加快 已優化
call :StartReload & goto :StartupDelayInMSec

:StartupDelayInMSec_restore
reg delete "HKEY_CURRENT_USER\Software\Microsoft \Windows\CurrentVersion\Explorer\Serialize" /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 資料夾開啟速度加快 已還原
call :StartReload & goto :StartupDelayInMSec

::==========================================  HybridBoot Action  ==========================================================================

:HybridBoot
call :DisplayMessage_01 "開啟快速啟動(Hybrid Boot)"
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :HybridBoot_restore
if errorlevel 1 goto :HybridBoot_execute

:HybridBoot_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\System" /v "HiberbootEnabled" /d 1 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "開啟快速啟動(Hybrid Boot)" 已優化
call :StartReload & goto :HybridBoot

:HybridBoot_restore
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\System" /v "HiberbootEnabled" /d 0 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "開啟快速啟動(Hybrid Boot)" 已還原
call :StartReload & goto :HybridBoot

::===========================================  WaitToKillServiceTimeout Action  ==================================================================

:WaitToKillServiceTimeout
call :DisplayMessage_01 關機時強制關閉背景程式不等待
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :WaitToKillServiceTimeout_restore
if errorlevel 1 goto :WaitToKillServiceTimeout_execute

:WaitToKillServiceTimeout_execute
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control" /v "WaitToKillServiceTimeout" /d 0 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關機時強制關閉背景程式不等待 已優化
call :StartReload & goto :WaitToKillServiceTimeout

:WaitToKillServiceTimeout_restore
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control" /v "WaitToKillServiceTimeout" /d 5000 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關機時強制關閉背景程式不等待 已還原
call :StartReload & goto :WaitToKillServiceTimeout

::=========================================  DisallowAnimations Action  ==========================================================================

:DisallowAnimations
call :DisplayMessage_01 關閉不必要的視覺動畫效果
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :DisallowAnimations_restore
if errorlevel 1 goto :DisallowAnimations_execute

:DisallowAnimations_execute
reg add "HKEY_CURRENT_USER\Software\Policies\Microsoft\Windows\DWM" /v "DisallowAnimations" /d 1 /t REG_dword /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer" /v "TurnOffSPIAnimations" /d 1 /t REG_dword /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Control Panel\Desktop\WindowMetrics" /v "MinAnimate" /d 0 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關閉不必要的視覺動畫效果 已優化
call :StartReload & goto :DisallowAnimations

:DisallowAnimations_restore
reg delete "HKEY_CURRENT_USER\Software\Policies\Microsoft\Windows\DWM" /f >nul 2>nul
reg delete "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer" /v "TurnOffSPIAnimations" /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Control Panel\Desktop\WindowMetrics" /v "MinAnimate" /d 1 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關閉不必要的視覺動畫效果 已還原
call :StartReload & goto :DisallowAnimations

::===========================================  CEIPEnable Action  ==========================================================================

:CEIPEnable
call :DisplayMessage_01 關閉客戶體驗改善計劃
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :CEIPEnable_restore
if errorlevel 1 goto :CEIPEnable_execute

:CEIPEnable_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\SQMClient\Windows" /v "CEIPEnable" /d 0 /t REG_DWORD /f >nul 2>nul
sc stop DiagTrack >nul 2>nul
timeout 1 >nul 2>nul
sc config "DiagTrack" start= disabled >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關閉客戶體驗改善計劃 已優化
call :StartReload & goto :CEIPEnable

:CEIPEnable_restore
reg delete "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\SQMClient" /f >nul 2>nul
sc config "DiagTrack" start= delayed-auto >nul 2>nul
sc start DiagTrack >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 關閉客戶體驗改善計劃 已還原
call :StartReload & goto :CEIPEnable

::============================================  Superfetch Action ==========================================================================

:Superfetch
call :DisplayMessage_01 "關閉 Superfetch 服務"
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :Superfetch_restore
if errorlevel 1 goto :Superfetch_execute

:Superfetch_execute
sc stop SysMain >nul 2>nul
timeout 1 >nul 2>nul
sc config "SysMain" start= disabled >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "關閉 Superfetch 服務" 已優化
call :StartReload & goto :Superfetch

:Superfetch_restore
sc config "SysMain" start= auto >nul 2>nul
sc start SysMain >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "關閉 Superfetch 服務" 已還原
call :StartReload & goto :Superfetch

::===========================================  HomeGroup Action  ==========================================================================

:HomeGroup
call :DisplayMessage_01 "關閉 HomeGroup 家用群組"
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :HomeGroup_restore
if errorlevel 1 goto :HomeGroup_execute

:HomeGroup_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\HomeGroup" /v "DisableHomeGroup" /d 1 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "關閉 HomeGroup 家用群組" 已優化
call :StartReload & goto :HomeGroup

:HomeGroup_restore
reg delete "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\HomeGroup" /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "關閉 HomeGroup 家用群組" 已還原
call :StartReload & goto :HomeGroup

::===========================================  WSearch Action  =============================================================================

:WSearch
call :DisplayMessage_01 禁用索引服務
choice /C:123 /N /M ">                 在鍵盤上輸入你的選擇 [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :WSearch_restore
if errorlevel 1 goto :WSearch_execute

:WSearch_execute
sc stop WMPNetworkSvc >nul 2>nul
timeout 1 >nul 2>nul
sc stop WSearch >nul 2>nul
timeout 1 >nul 2>nul
sc config "WMPNetworkSvc" start= disabled >nul 2>nul
sc config "WSearch" start= disabled >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 禁用索引服務 已優化
call :StartReload & goto :WSearch

:WSearch_restore
sc config "WSearch" start= auto >nul 2>nul
sc config "WMPNetworkSvc" start= delayed-auto >nul 2>nul
sc start WSearch >nul 2>nul
timeout 1 >nul 2>nul
sc start WMPNetworkSvc >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 禁用索引服務 已還原
call :StartReload & goto :WSearch

::=============================================  Others Action  ======================================================================

:StartReload
gpupdate /force
taskkill /f /im explorer.exe >nul 2>nul
timeout /t 1
start %systemroot%\explorer >nul 2>nul
pause
echo 按下任意鍵繼續...
exit /b

:DisplayMessage_01
setlocal DisableDelayedExpansion
cls
color 0a

echo:
echo:
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|      Windows 服務 - %1
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] 優化                                                 ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] 還原                                                 ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] 返回主選單                                           ^|
echo                  ^|_______________________________________________________________^|
echo:
endlocal
exit /b

:DisplayMessage_02
setlocal DisableDelayedExpansion
color 0a

if %autoEnable%==0 (
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|      Windows 服務 - %1 %2
echo                  ^|_______________________________________________________________^|
) else (
echo                  ^|                                                               ^|
echo                  ^|      Windows 服務 - %1 %2
)
endlocal
exit /b

:Error
color 0c

echo:
echo 操作失敗，按下任意鍵返回主選單...
goto :Exit

:Exit
exit /b

::========================================================================================================================================

::End::