@echo off
:: some comment
::set PATH=%CD%;%PATH%;
setlocal enabledelayedexpansion

for /R D:\Ava\Empirical2018\TrojansResult\API-deleted %%X in (*.txt) do (		

set name=%%~nX
set value=!name:~0,5!
@echo !value!
type %%X >> D:%%~pX!value!.txt

)

::copy "D:\Ava\Empirical2018\AdwaresResult\API-added\test\%_c%*.txt" "D:\Ava\Empirical2018\AdwaresResult\API-added\test\%_c%.txt"

::xcopy %%X "D:%%~pX%%~nX:~0,5
::SETLOCAL
::SET _c=%%~nX
::SET _cc=%_c%:~0,5
::echo %_c%

for /R D:\Ava\Empirical2018\Adwares\ %%X in (*.apk) do (		
set cdir= "c:\Ava\android\dex2java\dex2jar-2.0\dex2jar-2.0\%%~nX-dex2jar.jar"
set ddir= "D:%%~pX%%~nX.jar"
echo ****%cdir%
echo ****%ddir%
move "c:\Ava\android\dex2java\dex2jar-2.0\dex2jar-2.0\%%~nX-dex2jar.jar" "D:%%~pX%%~nX.jar"

)

for /R D:\Ava\Empirical2018\Adwares\ %%X in (*.jar) do (		

mkdir -p "%%~pX/%%~nX"
(cd "%%~pX/%%~nX" && "C:\Program Files\Java\jdk1.7.0_80\bin\jar" -xvf %%X)

mkdir -p "%%~pX/%%~nX-java"
c:\Ava\android\dex2java\jd-gui-windows-1.4.0\jad -o -r -sjava -d"%%~pX/%%~nX-java" "%%~pX/%%~nX"/**/*.class



)
for /r D:\Ava\Empirical2018\AdwaresResult\repackagedManipulated %%X in (*.txt) do (

APItrace2018R.jar %%X D:\Ava\Empirical2018\AdwaresResult\API-repackagedManipulated\%%~nX.txt D:\Ava\Empirical2018\AdwaresResult\API-P-repackagedManipulated\%%~nX.txt
echo %%~nX
)
timeout /t -1