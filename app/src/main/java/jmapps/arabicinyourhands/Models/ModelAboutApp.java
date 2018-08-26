package jmapps.arabicinyourhands.Models;

import jmapps.arabicinyourhands.R;

public class ModelAboutApp {

    private final int pictureApp;
    private final String nameApp;

    public static final ModelAboutApp[] aboutAppContent = {
            new ModelAboutApp(R.drawable.ic_svg_code, "В приложении более 3 тысяч строк кода"),
            new ModelAboutApp(R.drawable.ic_svg_database, "1884 пункта в базе данных"),
            new ModelAboutApp(R.drawable.ic_svg_mp3, "2404 аудиофайла"),
            new ModelAboutApp(R.drawable.ic_svg_coffee, "Неизвестное количество выпитых чашек кофе"),
            new ModelAboutApp(R.drawable.ic_svg_layers, "Все иконки взяты с сайта www.flaticon.com"),
            new ModelAboutApp(R.drawable.ic_svg_translation, "Идея и текстовая версия взяты с сайта www.ar-ru.ru/arabiya")
    };

    private ModelAboutApp(int pictureApp, String nameApp) {
        this.pictureApp = pictureApp;
        this.nameApp = nameApp;
    }

    public int getPictureApp() {
        return pictureApp;
    }

    public String getNameApp() {
        return nameApp;
    }
}
