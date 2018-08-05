package jmapps.arabicinyourhands.Models;

import jmapps.arabicinyourhands.R;

public class ModelListApps {

    private final int pictureApp;
    private final String nameApp;
    private final String linkApp;

    public static final ModelListApps[] listAppsContent = {
            new ModelListApps(R.drawable.hadith, "40 хадисов имама ан-Навави",
                    "https://play.google.com/store/apps/details?id=jmapps.hadith40"),
            new ModelListApps(R.drawable.questions, "200 вопросов по вероучению Ислама",
                    "https://play.google.com/store/apps/details?id=jmapps.questions200"),
            new ModelListApps(R.drawable.strength, "Сила воли",
                    "https://play.google.com/store/apps/details?id=jmapps.strengthofwill"),
            new ModelListApps(R.drawable.thenames, "Толкование прекрасных имен Аллаха",
                    "https://play.google.com/store/apps/details?id=jmapps.thenamesof"),
            new ModelListApps(R.drawable.fortress, "Крепость мусульманина",
                    "https://play.google.com/store/apps/details?id=jmapps.fortressofthemuslim"),
            new ModelListApps(R.drawable.lessons, "Уроки Рамадана",
                    "https://play.google.com/store/apps/details?id=jmapps.lessonsoframadan"),
            new ModelListApps(R.drawable.arabic_hands, "Арабский в твоих руках. Том 1.",
                    "https://play.google.com/store/apps/details?id=jmapps.arabicinyourhands")
    };

    private ModelListApps(int pictureApp, String nameApp, String linkApp) {
        this.pictureApp = pictureApp;
        this.nameApp = nameApp;
        this.linkApp = linkApp;
    }

    public int getPictureApp() {
        return pictureApp;
    }

    public String getNameApp() {
        return nameApp;
    }

    public String getLinkApp() {
        return linkApp;
    }
}
