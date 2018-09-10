copy ..\..\actionscript\lib\AppMetrica.swc ..\temp\AppMetrica.swc
copy ..\..\java\AppMetrica\app\build\outputs\aar\app-debug.aar ..\temp\libAppMetrica.aar

7z.exe x ..\temp\AppMetrica.swc -o..\temp\swc
7z.exe x ..\temp\libAppMetrica.aar -o..\temp\jar

move ..\temp\jar\classes.jar ..\Android-ARM\libAppMetrica.jar
move ..\temp\swc\library.swf ..\Android-ARM\library.swf

rd ..\temp\jar /s /q
rd ..\temp\swc /s /q