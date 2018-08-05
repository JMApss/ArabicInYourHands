package jmapps.arabicinyourhands.Models;

import jmapps.arabicinyourhands.R;

public class ModelMainChapters {

    private final int iconMainChapter;
    private final int iconMainChapterWhite;
    private final String titleMainChapter;
    private final String subTitleMainChapter;
    private final String setContentMainNumber;

    public static final ModelMainChapters[] modelMainChapters = {
        new ModelMainChapters(R.drawable.ic_svg_hand_shake, R.drawable.ic_svg_hand_shake_white,
                "Приветствие и знакомство", "التَّحِيَّةُ و التَّعارُفُ",
        "hand_shake"),
        new ModelMainChapters(R.drawable.ic_svg_family, R.drawable.ic_svg_family_white,
                "Семья", "اﻷْسْرةُ",
                "family"),
        new ModelMainChapters(R.drawable.ic_svg_home, R.drawable.ic_svg_home_white,
                "Жильё", "السَّكَنُ",
                "home"),
        new ModelMainChapters(R.drawable.ic_svg_daily, R.drawable.ic_svg_daily_white,
                "Повседневная жизнь", "الحَياةُ اليَوْمِيَّةُ",
                "daily"),
        new ModelMainChapters(R.drawable.ic_svg_eat, R.drawable.ic_svg_eat_white,
                "Еда и напитки", "الطَّعامُ و الشَّرابُ",
                "eat"),
        new ModelMainChapters(R.drawable.ic_svg_prayer, R.drawable.ic_svg_prayer_white,
                "Молитва", "الصَّلاةُ",
                "prayer"),
        new ModelMainChapters(R.drawable.ic_svg_studies, R.drawable.ic_svg_studies_white,
                "Учёба", "الدِّراسَةُ",
                "studies"),
        new ModelMainChapters(R.drawable.ic_svg_work, R.drawable.ic_svg_work_white,
                "Работа", "العَمَلُ",
                "work"),
        new ModelMainChapters(R.drawable.ic_svg_shopping, R.drawable.ic_svg_shopping_white,
                "Покупки", "التَّسَوُّقُ",
                "shopping"),
        new ModelMainChapters(R.drawable.ic_svg_weather, R.drawable.ic_svg_weather_white,
                "Погода", "الجَوُّ",
                "weather"),
        new ModelMainChapters(R.drawable.ic_svg_countries, R.drawable.ic_svg_countries_white,
                "Люди и страны", "النَّاسُ  واﻷَماكِنُ",
                "countries"),
        new ModelMainChapters(R.drawable.ic_svg_intertament, R.drawable.ic_svg_intertament_white,
                "Развлечения", "الهِواياتُ",
                "intertament"),
        new ModelMainChapters(R.drawable.ic_svg_travels, R.drawable.ic_svg_travels_white,
                "Путешествие", "السَّفَرُ",
                "travels"),
        new ModelMainChapters(R.drawable.ic_svg_hadj, R.drawable.ic_svg_hadj_white,
                "Хадж и умра", "الحَجُّ و العُمْرَةُ",
                "hadj"),
        new ModelMainChapters(R.drawable.ic_svg_health, R.drawable.ic_svg_health_white,
                "Здоровье", "الصِّحَّةُ",
                "health"),
        new ModelMainChapters(R.drawable.ic_svg_holiday, R.drawable.ic_svg_holiday_white,
                "Каникулы", "العُطْلَةُ",
                "holiday")
    };

    private ModelMainChapters(int iconMainChapter, int iconMainChapterWhite,
                              String titleMainChapter, String subTitleMainChapter,
                              String setContentMainNumber) {
        this.iconMainChapter = iconMainChapter;
        this.iconMainChapterWhite = iconMainChapterWhite;
        this.titleMainChapter = titleMainChapter;
        this.subTitleMainChapter = subTitleMainChapter;
        this.setContentMainNumber = setContentMainNumber;
    }

    public int getIconMainChapter() {
        return iconMainChapter;
    }

    public int getIconMainChapterWhite() {
        return iconMainChapterWhite;
    }

    public String getTitleMainChapter() {
        return titleMainChapter;
    }

    public String getSubTitleMainChapter() {
        return subTitleMainChapter;
    }

    public String getSetContentMainNumber() {
        return setContentMainNumber;
    }
}
