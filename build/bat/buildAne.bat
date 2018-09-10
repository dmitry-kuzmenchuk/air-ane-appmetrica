set OUT_ANE=..\out\com.menu4me.ane.AppMetrica.ane
set EXT_XML=..\xml\extension.xml
set SWC=..\temp\AppMetrica.swc

"C:\flex_4_16_air_24\bin\adt" -package -target ane %OUT_ANE% %EXT_XML% -swc %SWC% -platform Android-ARM -C ..\Android-ARM .