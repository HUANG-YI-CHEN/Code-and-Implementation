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
echo                  ^|                       Windows 10 �u��                         ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows �A�� �i�۰ʡj - �u��/�٭�                    ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows �A�� �i��ʡj - �u��/�٭�                    ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] �h�X                                                 ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|                                                               ^|
echo                  ^|             �������D�^��  neil2013707@hotmail.com             ^|
echo                  ^|                                                               ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "

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
echo                  ^|                       Windows 10 �u�� �i�۰ʡj                ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows �A�� �i�u�ơj                                ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows �A�� �i�٭�j                                ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] ��^�D���                                           ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "

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
call :DisplayMessage_02 System�O����e�� �w�u��
call :DisplayMessage_02 ��Ƨ��}�ҳt�ץ[�� �w�u��
call :DisplayMessage_02 "�}�ҧֳt�Ұ�(Hybrid Boot)" �w�u��
call :DisplayMessage_02 �����ɱj�������I���{�������� �w�u��
call :DisplayMessage_02 ���������n����ı�ʵe�ĪG �w�u��
call :DisplayMessage_02 �����Ȥ�����ﵽ�p�� �w�u��
call :DisplayMessage_02 "���� Superfetch" �w�u��
call :DisplayMessage_02 "���� HomeGroup �a�θs��" �w�u��
call :DisplayMessage_02 �T�ί��ުA�� �w�u��
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
call :DisplayMessage_02 System�O����e�� �w�٭�
call :DisplayMessage_02 ��Ƨ��}�ҳt�ץ[�� �w�٭�
call :DisplayMessage_02 "�}�ҧֳt�Ұ�(Hybrid Boot)" �w�٭�
call :DisplayMessage_02 �����ɱj�������I���{�������� �w�٭�
call :DisplayMessage_02 ���������n����ı�ʵe�ĪG �w�٭�
call :DisplayMessage_02 �����Ȥ�����ﵽ�p�� �w�٭�
call :DisplayMessage_02 "���� Superfetch" �w�٭�
call :DisplayMessage_02 "���� HomeGroup �a�θs��" �w�٭�
call :DisplayMessage_02 �T�ί��ުA�� �w�٭�
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
echo                  ^|                       Windows 10 ����u��                     ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] Windows �A�� - System�O����e��                      ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] Windows �A�� - ��Ƨ��}�ҳt�ץ[��                    ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] Windows �A�� - �}�ҧֳt�Ұ�(Hybrid Boot)             ^|
echo                  ^|                                                               ^|
echo                  ^|      [4] Windows �A�� - �����ɱj�������I���{��������          ^|
echo                  ^|                                                               ^|
echo                  ^|      [5] Windows �A�� - ���������n����ı�ʵe�ĪG              ^|
echo                  ^|                                                               ^|
echo                  ^|      [6] Windows �A�� - �����Ȥ�����ﵽ�p��                  ^|
echo                  ^|                                                               ^|
echo                  ^|      [7] Windows �A�� - ���� Superfetch �A��                  ^|
echo                  ^|                                                               ^|
echo                  ^|      [8] Windows �A�� - ���� HomeGroup �a�θs��               ^|
echo                  ^|                                                               ^|
echo                  ^|      [9] Windows �A�� - �T�ί��ުA��                          ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [M] ��^�D���  [N] �U�@��                               ^|
echo                  ^|_______________________________________________________________^|
echo:
choice /C:123456789MN /N /M ">                 �b��L�W��J�A����� [0,1,2,3,4,5,6,7,8,9,M,N] : "
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
call :DisplayMessage_01 System�O����e��
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :SystemSuperfetch_restore
if errorlevel 1 goto :SystemSuperfetch_execute

:SystemSuperfetch_execute
reg add "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Ndu" /v "Start" /d 4 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnablePrefetcher" /d 0 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnableSuperfetch" /d 0 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 System�O����e�� �w�u��
call :StartReload & goto :SystemSuperfetch

:SystemSuperfetch_restore
reg add "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Ndu" /v "Start" /d 2 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnablePrefetcher" /d 3 /t REG_DWORD /f >nul 2>nul
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Memory Management\PrefetchParameters" /v "EnableSuperfetch" /d 3 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 System�O����e�� �w�٭�
call :StartReload & goto :SystemSuperfetch

::=========================================  StartupDelayInMSec Action  ==================================================================

:StartupDelayInMSec
call :DisplayMessage_01 ��Ƨ��}�ҳt�ץ[��
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :StartupDelayInMSec_restore
if errorlevel 1 goto :StartupDelayInMSec_execute

:StartupDelayInMSec_execute
reg add "HKEY_CURRENT_USER\Software\Microsoft \Windows\CurrentVersion\Explorer\Serialize" /v "StartupDelayInMSec" /d "0" /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 ��Ƨ��}�ҳt�ץ[�� �w�u��
call :StartReload & goto :StartupDelayInMSec

:StartupDelayInMSec_restore
reg delete "HKEY_CURRENT_USER\Software\Microsoft \Windows\CurrentVersion\Explorer\Serialize" /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 ��Ƨ��}�ҳt�ץ[�� �w�٭�
call :StartReload & goto :StartupDelayInMSec

::==========================================  HybridBoot Action  ==========================================================================

:HybridBoot
call :DisplayMessage_01 "�}�ҧֳt�Ұ�(Hybrid Boot)"
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :HybridBoot_restore
if errorlevel 1 goto :HybridBoot_execute

:HybridBoot_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\System" /v "HiberbootEnabled" /d 1 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "�}�ҧֳt�Ұ�(Hybrid Boot)" �w�u��
call :StartReload & goto :HybridBoot

:HybridBoot_restore
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\System" /v "HiberbootEnabled" /d 0 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "�}�ҧֳt�Ұ�(Hybrid Boot)" �w�٭�
call :StartReload & goto :HybridBoot

::===========================================  WaitToKillServiceTimeout Action  ==================================================================

:WaitToKillServiceTimeout
call :DisplayMessage_01 �����ɱj�������I���{��������
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :WaitToKillServiceTimeout_restore
if errorlevel 1 goto :WaitToKillServiceTimeout_execute

:WaitToKillServiceTimeout_execute
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control" /v "WaitToKillServiceTimeout" /d 0 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 �����ɱj�������I���{�������� �w�u��
call :StartReload & goto :WaitToKillServiceTimeout

:WaitToKillServiceTimeout_restore
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control" /v "WaitToKillServiceTimeout" /d 5000 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 �����ɱj�������I���{�������� �w�٭�
call :StartReload & goto :WaitToKillServiceTimeout

::=========================================  DisallowAnimations Action  ==========================================================================

:DisallowAnimations
call :DisplayMessage_01 ���������n����ı�ʵe�ĪG
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :DisallowAnimations_restore
if errorlevel 1 goto :DisallowAnimations_execute

:DisallowAnimations_execute
reg add "HKEY_CURRENT_USER\Software\Policies\Microsoft\Windows\DWM" /v "DisallowAnimations" /d 1 /t REG_dword /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer" /v "TurnOffSPIAnimations" /d 1 /t REG_dword /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Control Panel\Desktop\WindowMetrics" /v "MinAnimate" /d 0 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 ���������n����ı�ʵe�ĪG �w�u��
call :StartReload & goto :DisallowAnimations

:DisallowAnimations_restore
reg delete "HKEY_CURRENT_USER\Software\Policies\Microsoft\Windows\DWM" /f >nul 2>nul
reg delete "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer" /v "TurnOffSPIAnimations" /f >nul 2>nul
reg add "HKEY_CURRENT_USER\Control Panel\Desktop\WindowMetrics" /v "MinAnimate" /d 1 /t REG_SZ /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 ���������n����ı�ʵe�ĪG �w�٭�
call :StartReload & goto :DisallowAnimations

::===========================================  CEIPEnable Action  ==========================================================================

:CEIPEnable
call :DisplayMessage_01 �����Ȥ�����ﵽ�p��
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :CEIPEnable_restore
if errorlevel 1 goto :CEIPEnable_execute

:CEIPEnable_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\SQMClient\Windows" /v "CEIPEnable" /d 0 /t REG_DWORD /f >nul 2>nul
sc stop DiagTrack >nul 2>nul
timeout 1 >nul 2>nul
sc config "DiagTrack" start= disabled >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 �����Ȥ�����ﵽ�p�� �w�u��
call :StartReload & goto :CEIPEnable

:CEIPEnable_restore
reg delete "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\SQMClient" /f >nul 2>nul
sc config "DiagTrack" start= delayed-auto >nul 2>nul
sc start DiagTrack >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 �����Ȥ�����ﵽ�p�� �w�٭�
call :StartReload & goto :CEIPEnable

::============================================  Superfetch Action ==========================================================================

:Superfetch
call :DisplayMessage_01 "���� Superfetch �A��"
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :Superfetch_restore
if errorlevel 1 goto :Superfetch_execute

:Superfetch_execute
sc stop SysMain >nul 2>nul
timeout 1 >nul 2>nul
sc config "SysMain" start= disabled >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "���� Superfetch �A��" �w�u��
call :StartReload & goto :Superfetch

:Superfetch_restore
sc config "SysMain" start= auto >nul 2>nul
sc start SysMain >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "���� Superfetch �A��" �w�٭�
call :StartReload & goto :Superfetch

::===========================================  HomeGroup Action  ==========================================================================

:HomeGroup
call :DisplayMessage_01 "���� HomeGroup �a�θs��"
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
if errorlevel 3 goto :MainMenu
if errorlevel 2 goto :HomeGroup_restore
if errorlevel 1 goto :HomeGroup_execute

:HomeGroup_execute
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\HomeGroup" /v "DisableHomeGroup" /d 1 /t REG_DWORD /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "���� HomeGroup �a�θs��" �w�u��
call :StartReload & goto :HomeGroup

:HomeGroup_restore
reg delete "HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows\HomeGroup" /f >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 "���� HomeGroup �a�θs��" �w�٭�
call :StartReload & goto :HomeGroup

::===========================================  WSearch Action  =============================================================================

:WSearch
call :DisplayMessage_01 �T�ί��ުA��
choice /C:123 /N /M ">                 �b��L�W��J�A����� [1,2,3] : "
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
call :DisplayMessage_02 �T�ί��ުA�� �w�u��
call :StartReload & goto :WSearch

:WSearch_restore
sc config "WSearch" start= auto >nul 2>nul
sc config "WMPNetworkSvc" start= delayed-auto >nul 2>nul
sc start WSearch >nul 2>nul
timeout 1 >nul 2>nul
sc start WMPNetworkSvc >nul 2>nul
timeout 1 >nul 2>nul
if %autoEnable%==1 goto exit /b
call :DisplayMessage_02 �T�ί��ުA�� �w�٭�
call :StartReload & goto :WSearch

::=============================================  Others Action  ======================================================================

:StartReload
gpupdate /force
taskkill /f /im explorer.exe >nul 2>nul
timeout /t 1
start %systemroot%\explorer >nul 2>nul
pause
echo ���U���N���~��...
exit /b

:DisplayMessage_01
setlocal DisableDelayedExpansion
cls
color 0a

echo:
echo:
echo                   _______________________________________________________________
echo                  ^|                                                               ^|
echo                  ^|      Windows �A�� - %1
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [1] �u��                                                 ^|
echo                  ^|                                                               ^|
echo                  ^|      [2] �٭�                                                 ^|
echo                  ^|      ___________________________________________________      ^|
echo                  ^|                                                               ^|
echo                  ^|      [3] ��^�D���                                           ^|
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
echo                  ^|      Windows �A�� - %1 %2
echo                  ^|_______________________________________________________________^|
) else (
echo                  ^|                                                               ^|
echo                  ^|      Windows �A�� - %1 %2
)
endlocal
exit /b

:Error
color 0c

echo:
echo �ާ@���ѡA���U���N���^�D���...
goto :Exit

:Exit
exit /b

::========================================================================================================================================

::End::