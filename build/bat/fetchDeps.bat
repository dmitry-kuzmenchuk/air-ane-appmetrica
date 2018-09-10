:: AppMetrica library
set AM_DIR=C:\android-sdk\extras
set AM_DEP=mobmetricalib
set AM_VER=2.62

copy %AM_DIR%\%AM_DEP%-%AM_VER%.aar ..\temp\%AM_DEP%-%AM_VER%.aar
7z.exe x ..\temp\%AM_DEP%-%AM_VER%.aar -o..\temp\%AM_DEP%-%AM_VER%
7z.exe x ..\temp\%AM_DEP%-%AM_VER%\classes.jar -o..\deps\
rd ..\deps\META-INF /s /q

:: Google Json library
set GSON_DIR=c:\android-sdk\extras
set GSON_DEP=gson
set GSON_VERSION=2.8.0

copy %GSON_DIR%\%GSON_DEP%-%GSON_VERSION%.jar ..\temp\%GSON_DEP%-%GSON_VERSION%.jar
7z.exe x ..\temp\%GSON_DEP%-%GSON_VERSION%.jar -o..\deps\
rd ..\deps\META-INF /s /q