CREATE DATABASE WaifuDB;
USE WaifuDB;

CREATE TABLE Waifus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL DEFAULT "Desconocido",
    apellido VARCHAR(50) NOT NULL DEFAULT "Desconocido",
    edad INT NOT NULL DEFAULT 0000,
    tipo VARCHAR(20) NOT NULL DEFAULT "Desconocido",
    anime VARCHAR(100) NOT NULL DEFAULT "Desconocido",
    fecha_nacimiento VARCHAR(10) NOT NULL DEFAULT "0000-00-00"
);

INSERT INTO Waifus (nombre, apellido, edad, tipo, anime, fecha_nacimiento) VALUES
-- Gotoubun no Hanayome (10)
("Ichika", "Nakano", 17, "Humano", "Gotoubun no Hanayome", "2000-05-05"), ("Nino", "Nakano", 17, "Humano", "Gotoubun no Hanayome", "2000-05-05"),
("Miku", "Nakano", 17, "Humano", "Gotoubun no Hanayome", "2000-05-05"), ("Yotsuba", "Nakano", 17, "Humano", "Gotoubun no Hanayome", "2000-05-05"),
("Itsuki", "Nakano", 17, "Humano", "Gotoubun no Hanayome", "2000-05-05"), ("Raiha", "Uesugi", 11, "Humano", "Gotoubun no Hanayome", "2006-04-15"),
("Eba", NULL, 17, "Humano", "Gotoubun no Hanayome", "2000-06-10"), ("Rena", "Nakano", NULL, "Humano", "Gotoubun no Hanayome", NULL),
("Maruo", "Nakano", 45, "Humano", "Gotoubun no Hanayome", "1972-10-10"), ("Yuki", "Matsuo", 16, "Humano", "Gotoubun no Hanayome", "2001-03-15"),

-- Seishun Buta Yarou (12)
("Mai", "Sakurajima", 18, "Humano", "Seishun Buta Yarou", "1999-12-02"), ("Kaede", "Azusagawa", 15, "Humano", "Seishun Buta Yarou", "2002-11-05"),
("Tomoe", "Koga", 16, "Humano", "Seishun Buta Yarou", "2001-06-15"), ("Nodoka", "Toyohama", 18, "Humano", "Seishun Buta Yarou", "1999-08-10"),
("Rio", "Futaba", 17, "Humano", "Seishun Buta Yarou", "2000-10-23"), ("Shoko", "Makinohara", 14, "Humano", "Seishun Buta Yarou", "2003-08-10"),
("Saki", "Kamizaka", 17, "Humano", "Seishun Buta Yarou", "2000-09-12"), ("Rika", "Honjo", 16, "Humano", "Seishun Buta Yarou", "2001-07-18"),
("Fumika", "Nanjo", 25, "Humano", "Seishun Buta Yarou", "1992-01-30"), ("Yuma", "Kunimi", 17, "Humano", "Seishun Buta Yarou", "2000-03-05"),
("Uzuki", "Hirokawa", 16, "Humano", "Seishun Buta Yarou", "2001-04-04"), ("Aya", "Kamizato", 17, "Humano", "Seishun Buta Yarou", "2000-02-14"),

-- Date a Live (20)
("Kurumi", "Tokisaki", NULL, "espiritu", "Date a Live", NULL), ("Tohka", "Yatogami", NULL, "espiritu", "Date a Live", NULL),
("Origami", "Tobiichi", 16, "Humano", "Date a Live", "2001-03-03"), ("Yoshino", NULL, NULL, "espiritu", "Date a Live", NULL),
("Kotori", "Itsuka", 14, "Hibrido", "Date a Live", "2003-08-03"), ("Miku", "Izayoi", NULL, "espiritu", "Date a Live", NULL),
("Natsumi", NULL, NULL, "espiritu", "Date a Live", NULL), ("Kaguya", "Yamai", NULL, "espiritu", "Date a Live", NULL),
("Yuzuru", "Yamai", NULL, "espiritu", "Date a Live", NULL), ("Mayuri", NULL, NULL, "espiritu", "Date a Live", NULL),
("Nia", "Honjou", NULL, "espiritu", "Date a Live", NULL), ("Reine", "Murasame", NULL, "Desconocido", "Date a Live", NULL),
("Ellen", "Mira Mathers", 30, "Humano", "Date a Live", "1987-06-15"), ("Mana", "Takamiya", 15, "Humano", "Date a Live", "2002-11-20"),
("Mukuro", "Hoshimiya", NULL, "espiritu", "Date a Live", NULL), ("Ryouko", "Kusakabe", 25, "Humano", "Date a Live", "1992-05-10"),
("Tamae", "Okamine", 28, "Humano", "Date a Live", "1989-09-09"), ("Ai", "Yamabuki", 16, "Humano", "Date a Live", "2001-04-12"),
("Mai", "Hazakura", 16, "Humano", "Date a Live", "2001-04-12"), ("Mii", "Fujibakama", 16, "Humano", "Date a Live", "2001-04-12"),

-- Rent a Girlfriend (10)
("Chizuru", "Mizuhara", 20, "Humano", "Rent a Girlfriend", "1997-04-19"), ("Mami", "Nanami", 19, "Humano", "Rent a Girlfriend", "1998-06-13"),
("Ruka", "Sarashina", 17, "Humano", "Rent a Girlfriend", "2000-08-26"), ("Sumi", "Sakurasawa", 19, "Humano", "Rent a Girlfriend", "1998-03-20"),
("Mini", "Yaemori", 21, "Humano", "Rent a Girlfriend", "1996-11-11"), ("Sayuri", "Ichinose", 60, "Humano", "Rent a Girlfriend", "1957-12-25"),
("Nagomi", "Kinoshita", 70, "Humano", "Rent a Girlfriend", "1947-03-03"), ("Harumi", "Sakurasawa", 45, "Humano", "Rent a Girlfriend", "1972-09-18"),
("Mizuhara", "Ichinose", 20, "Humano", "Rent a Girlfriend", "1997-04-19"), ("Asami", "Nanami", 19, "Humano", "Rent a Girlfriend", "1998-07-07"),

-- Frieren (15)
("Frieren", NULL, 1000, "Elfo", "Frieren", NULL), ("Fern", NULL, 16, "Humano", "Frieren", "2009-01-15"),
("Aura", NULL, NULL, "Demonio", "Frieren", NULL), ("Linie", NULL, NULL, "Demonio", "Frieren", NULL),
("Lugner", NULL, NULL, "Demonio", "Frieren", NULL), ("Serie", NULL, 500, "Elfo", "Frieren", NULL),
("Ubel", NULL, 20, "Humano", "Frieren", "1997-05-22"), ("Kanne", NULL, 19, "Humano", "Frieren", "1998-03-10"),
("Lawine", NULL, 19, "Humano", "Frieren", "1998-04-15"), ("Qual", NULL, NULL, "Demonio", "Frieren", NULL),
("Himmel", NULL, 26, "Humano", "Frieren", "1991-06-10"), ("Heiter", NULL, 30, "Humano", "Frieren", "1987-08-08"),
("Eisen", NULL, 50, "Humano", "Frieren", "1967-02-14"), ("Land", NULL, 22, "Humano", "Frieren", "1995-09-09"),
("Methode", NULL, 25, "Humano", "Frieren", "1992-11-11"),

-- Oshi no Ko (15)
("Ai", "Hoshino", 20, "Humano", "Oshi no Ko", "1997-05-01"), ("Ruby", "Hoshino", 16, "Humano", "Oshi no Ko", "2009-04-12"),
("Kana", "Arima", 17, "Humano", "Oshi no Ko", "2008-02-14"), ("Akane", "Kurokawa", 17, "Humano", "Oshi no Ko", "2008-07-07"),
("Mem-Cho", NULL, 25, "Humano", "Oshi no Ko", "1992-03-18"), ("Frill", "Shiranui", 18, "Humano", "Oshi no Ko", "1999-09-09"),
("Miyako", "Saitou", 30, "Humano", "Oshi no Ko", "1987-11-15"), ("Yuki", "Sumi", 16, "Humano", "Oshi no Ko", "2009-06-06"),
("Meimei", NULL, 17, "Humano", "Oshi no Ko", "2008-08-08"), ("Nino", NULL, 20, "Humano", "Oshi no Ko", "1997-03-03"),
("Kyoko", "Hoshino", 40, "Humano", "Oshi no Ko", "1977-05-05"), ("Hikaru", "Kamiki", 16, "Humano", "Oshi no Ko", "2009-04-12"),
("Taishi", "Gotanda", 35, "Humano", "Oshi no Ko", "1982-10-10"), ("Yorita", NULL, 18, "Humano", "Oshi no Ko", "1999-02-14"),
("Minami", "Kotobuki", 17, "Humano", "Oshi no Ko", "2008-03-15"),

-- Sword Art Online (20)
("Asuna", "Yuuki", 17, "Humano", "Sword Art Online", "2007-09-30"), ("Alice", "Margery", 17, "Humano", "Sword Art Online", "2007-04-09"),
("Sinon", "Asada", 16, "Humano", "Sword Art Online", "2008-08-21"), ("Leafa", "Kirigaya", 15, "Humano", "Sword Art Online", "2009-03-19"),
("Yuuki", "Konno", 15, "Humano", "Sword Art Online", "2010-05-23"), ("Silica", "Ayano", 14, "Humano", "Sword Art Online", "2010-10-04"),
("Lisbeth", "Shinozaki", 16, "Humano", "Sword Art Online", "2008-05-18"), ("Yuna", NULL, NULL, "Desconocido", "Sword Art Online", NULL),
("Sachi", NULL, 16, "Humano", "Sword Art Online", "2008-12-12"), ("Argo", NULL, 17, "Humano", "Sword Art Online", "2007-07-07"),
("Ronye", "Arabel", 17, "Humano", "Sword Art Online", "2007-06-06"), ("Tiese", "Shtolienen", 17, "Humano", "Sword Art Online", "2007-06-06"),
("Sortiliena", "Serlut", 19, "Humano", "Sword Art Online", "1998-05-05"), ("Frenica", "Szeski", 16, "Humano", "Sword Art Online", "2008-03-03"),
("Yui", NULL, NULL, "Desconocido", "Sword Art Online", NULL), ("Strea", NULL, NULL, "Desconocido", "Sword Art Online", NULL),
("Premiere", NULL, NULL, "Desconocido", "Sword Art Online", NULL), ("Philia", NULL, 16, "Humano", "Sword Art Online", "2008-04-04"),
("Rain", NULL, 15, "Humano", "Sword Art Online", "2009-09-09"), ("Seven", NULL, 14, "Humano", "Sword Art Online", "2010-10-10"),

-- Re:Zero (15)
("Rem", NULL, 19, "Demonio", "Re:Zero", "1998-02-02"), ("Ram", NULL, 19, "Demonio", "Re:Zero", "1998-02-02"),
("Emilia", NULL, 100, "Elfo", "Re:Zero", NULL), ("Beatrice", NULL, 400, "espiritu", "Re:Zero", NULL),
("Crusch", "Karsten", 20, "Humano", "Re:Zero", "1997-04-04"), ("Priscilla", "Barielle", 19, "Humano", "Re:Zero", "1998-09-07"),
("Felt", NULL, 15, "Humano", "Re:Zero", "2002-08-08"), ("Pandora", NULL, NULL, "Desconocido", "Re:Zero", NULL),
("Minerva", NULL, NULL, "espiritu", "Re:Zero", NULL), ("Echidna", NULL, NULL, "espiritu", "Re:Zero", NULL),
("Daphne", NULL, NULL, "espiritu", "Re:Zero", NULL), ("Typhon", NULL, NULL, "espiritu", "Re:Zero", NULL),
("Carmilla", NULL, NULL, "espiritu", "Re:Zero", NULL), ("Sekhmet", NULL, NULL, "espiritu", "Re:Zero", NULL),
("Satella", NULL, NULL, "Desconocido", "Re:Zero", NULL),

-- Demon Slayer (15)
("Nezuko", "Kamado", 14, "Demonio", "Demon Slayer", "2010-12-28"), ("Mitsuri", "Kanroji", 19, "Humano", "Demon Slayer", "1998-06-01"),
("Shinobu", "Kocho", 18, "Humano", "Demon Slayer", "1999-02-24"), ("Kanao", "Tsuyuri", 16, "Humano", "Demon Slayer", "2001-05-19"),
("Tamayo", NULL, 500, "Demonio", "Demon Slayer", NULL), ("Daki", NULL, 100, "Demonio", "Demon Slayer", NULL),
("Kanae", "Kocho", 21, "Humano", "Demon Slayer", "1996-04-15"), ("Aoi", "Kanzaki", 16, "Humano", "Demon Slayer", "2001-08-07"),
("Sumi", "Nakahara", 10, "Humano", "Demon Slayer", "2007-03-03"), ("Naho", "Takada", 10, "Humano", "Demon Slayer", "2007-05-05"),
("Kiyo", "Terauchi", 10, "Humano", "Demon Slayer", "2007-04-04"), ("Makomo", NULL, 13, "espiritu", "Demon Slayer", "2004-06-06"),
("Sabito", NULL, 13, "espiritu", "Demon Slayer", "2004-06-06"), ("Susamaru", NULL, NULL, "Demonio", "Demon Slayer", NULL),
("Muzan", "Kibutsuji", NULL, "Demonio", "Demon Slayer", NULL),

-- Attack on Titan (15)
("Mikasa", "Ackerman", 19, "Humano", "Attack on Titan", "1998-02-10"), ("Annie", "Leonhart", 20, "Humano", "Attack on Titan", "1997-03-22"),
("Historia", "Reiss", 19, "Humano", "Attack on Titan", "1998-01-15"), ("Sasha", "Blouse", 20, "Humano", "Attack on Titan", "1997-07-26"),
("Pieck", "Finger", 22, "Humano", "Attack on Titan", "1995-08-05"), ("Hange", "Zoe", 30, "Humano", "Attack on Titan", "1987-09-05"),
("Ymir", NULL, 17, "Humano", "Attack on Titan", "2000-02-17"), ("Gabi", "Braun", 12, "Humano", "Attack on Titan", "2005-04-14"),
("Kaya", NULL, 13, "Humano", "Attack on Titan", "2004-11-02"), ("Rico", "Brzenska", 25, "Humano", "Attack on Titan", "1992-12-12"),
("Petra", "Ral", 22, "Humano", "Attack on Titan", "1995-06-06"), ("Lynne", NULL, 23, "Humano", "Attack on Titan", "1994-03-03"),
("Nanaba", NULL, 28, "Humano", "Attack on Titan", "1989-07-07"), ("Ilse", "Langnar", 24, "Humano", "Attack on Titan", "1993-05-05"),
("Carla", "Yeager", 35, "Humano", "Attack on Titan", "1982-04-04"),

-- Konosuba (10)
("Aqua", NULL, NULL, "Desconocido", "Konosuba", NULL), ("Megumin", NULL, 14, "Humano", "Konosuba", "2010-12-04"),
("Darkness", NULL, 19, "Humano", "Konosuba", "1998-04-07"), ("Yunyun", NULL, 14, "Humano", "Konosuba", "2010-11-25"),
("Wiz", NULL, 20, "espiritu", "Konosuba", "1997-10-10"), ("Eris", NULL, NULL, "Desconocido", "Konosuba", NULL),
("Komekko", NULL, 8, "Humano", "Konosuba", "2016-05-05"), ("Cecily", NULL, 22, "Humano", "Konosuba", "1995-03-15"),
("Luna", NULL, 25, "Humano", "Konosuba", "1992-08-20"), ("Arue", NULL, 15, "Humano", "Konosuba", "2002-07-07"),

-- My Hero Academia (20)
("Ochaco", "Uraraka", 16, "Humano", "My Hero Academia", "2008-12-27"), ("Momo", "Yaoyorozu", 16, "Humano", "My Hero Academia", "2008-09-23"),
("Tsuyu", "Asui", 16, "Humano", "My Hero Academia", "2009-02-12"), ("Kyoka", "Jiro", 16, "Humano", "My Hero Academia", "2008-08-01"),
("Mina", "Ashido", 16, "Humano", "My Hero Academia", "2008-07-15"), ("Toru", "Hagakure", 16, "Humano", "My Hero Academia", "2008-06-16"),
("Itsuka", "Kendo", 16, "Humano", "My Hero Academia", "2008-09-09"), ("Nejire", "Hado", 17, "Humano", "My Hero Academia", "2007-10-06"),
("Eri", NULL, 6, "Humano", "My Hero Academia", "2018-12-21"), ("Mei", "Hatsume", 16, "Humano", "My Hero Academia", "2008-04-18"),
("Himiko", "Toga", 17, "Humano", "My Hero Academia", "2000-08-07"), ("Mt. Lady", NULL, 24, "Humano", "My Hero Academia", "1993-04-08"),
("Midnight", NULL, 31, "Humano", "My Hero Academia", "1986-03-09"), ("Mirko", NULL, 27, "Humano", "My Hero Academia", "1990-03-01"),
("Star", "Stripe", 30, "Humano", "My Hero Academia", "1987-07-07"), ("Fuyumi", "Todoroki", 23, "Humano", "My Hero Academia", "1994-12-06"),
("Rei", "Todoroki", 40, "Humano", "My Hero Academia", "1977-01-11"), ("Camie", "Utsushimi", 17, "Humano", "My Hero Academia", "2000-08-15"),
("Tatsuma", "Ryuko", 28, "Humano", "My Hero Academia", "1989-05-05"), ("Mina", "Hakamata", 25, "Humano", "My Hero Academia", "1992-06-06"),

-- Chainsaw Man (15)
("Makima", NULL, NULL, "Demonio", "Chainsaw Man", NULL), ("Power", NULL, NULL, "Demonio", "Chainsaw Man", NULL),
("Himeno", NULL, 24, "Humano", "Chainsaw Man", "1993-08-29"), ("Kobeni", "Higashiyama", 20, "Humano", "Chainsaw Man", "1997-09-15"),
("Reze", NULL, NULL, "Hibrido", "Chainsaw Man", NULL), ("Quanxi", NULL, 30, "Humano", "Chainsaw Man", "1987-05-05"),
("Fami", NULL, NULL, "Demonio", "Chainsaw Man", NULL), ("Asa", "Mitaka", 16, "Humano", "Chainsaw Man", "2001-09-20"),
("Nayuta", NULL, NULL, "Demonio", "Chainsaw Man", NULL), ("Cosmo", NULL, NULL, "Hibrido", "Chainsaw Man", NULL),
("Pingtsi", NULL, 28, "Humano", "Chainsaw Man", "1989-04-04"), ("Long", NULL, 25, "Humano", "Chainsaw Man", "1992-03-03"),
("Tsugihagi", NULL, NULL, "Hibrido", "Chainsaw Man", NULL), ("Yoru", NULL, NULL, "Demonio", "Chainsaw Man", NULL),
("Beam", NULL, NULL, "Demonio", "Chainsaw Man", NULL),

-- Darling in the Franxx (10)
("Zero Two", NULL, NULL, "Hibrido", "Darling in the Franxx", NULL), ("Ichigo", NULL, 16, "Humano", "Darling in the Franxx", "2009-10-15"),
("Miku", NULL, 16, "Humano", "Darling in the Franxx", "2009-10-15"), ("Kokoro", NULL, 16, "Humano", "Darling in the Franxx", "2009-10-15"),
("Ikuno", NULL, 16, "Humano", "Darling in the Franxx", "2009-10-15"), ("Nana", NULL, 30, "Humano", "Darling in the Franxx", "1987-07-07"),
("Naomi", NULL, 16, "Humano", "Darling in the Franxx", "2009-10-15"), ("Ai", NULL, 5, "Hibrido", "Darling in the Franxx", "2020-05-05"),
("Papa", NULL, NULL, "Desconocido", "Darling in the Franxx", NULL), ("Tarsier", NULL, NULL, "Desconocido", "Darling in the Franxx", NULL),

-- Spice and Wolf (5)
("Holo", NULL, 200, "espiritu", "Spice and Wolf", NULL), ("Nora", "Arendt", 18, "Humano", "Spice and Wolf", "1999-03-12"),
("Eve", "Boland", 25, "Humano", "Spice and Wolf", "1992-07-07"), ("Dian", "Rubens", 30, "Humano", "Spice and Wolf", "1987-06-06"),
("Fleur", "Boland", 20, "Humano", "Spice and Wolf", "1997-05-05"),

-- Fate Series (con femboy Astolfo) (20)
("Saber", NULL, NULL, "espiritu", "Fate/stay night", NULL), ("Rin", "Tohsaka", 17, "Humano", "Fate/stay night", "2000-02-03"),
("Sakura", "Matou", 17, "Humano", "Fate/stay night", "2000-03-02"), ("Illya", "von Einzbern", 10, "Hibrido", "Fate/stay night", "2007-11-20"),
("Astolfo", NULL, NULL, "espiritu", "Fate/Apocrypha", NULL), ("Jeanne", "d'Arc", NULL, "espiritu", "Fate/Apocrypha", NULL),
("Mordred", NULL, NULL, "espiritu", "Fate/Apocrypha", NULL), ("Semiramis", NULL, NULL, "espiritu", "Fate/Apocrypha", NULL),
("Atalanta", NULL, NULL, "espiritu", "Fate/Apocrypha", NULL), ("Jack", NULL, NULL, "espiritu", "Fate/Apocrypha", NULL),
("Tamamo", "no Mae", NULL, "espiritu", "Fate/Extra", NULL), ("Nero", "Claudius", NULL, "espiritu", "Fate/Extra", NULL),
("Okita", "Souji", NULL, "espiritu", "Fate/Grand Order", NULL), ("Musashi", "Miyamoto", NULL, "espiritu", "Fate/Grand Order", NULL),
("Ishtar", NULL, NULL, "espiritu", "Fate/Grand Order", NULL), ("Ereshkigal", NULL, NULL, "espiritu", "Fate/Grand Order", NULL),
("Scathach", NULL, NULL, "espiritu", "Fate/Grand Order", NULL), ("Artoria", "Lancer", NULL, "espiritu", "Fate/Grand Order", NULL),
("Mash", "Kyrielight", 16, "Hibrido", "Fate/Grand Order", "2001-07-07"), ("Kama", NULL, NULL, "espiritu", "Fate/Grand Order", NULL),

-- Naruto (15)
("Hinata", "Hyuga", 16, "Humano", "Naruto", "2001-12-27"), ("Sakura", "Haruno", 16, "Humano", "Naruto", "2001-03-28"),
("Tsunade", NULL, 50, "Humano", "Naruto", "1967-08-02"), ("Ino", "Yamanaka", 16, "Humano", "Naruto", "2001-09-23"),
("Temari", NULL, 18, "Humano", "Naruto", "1999-08-23"), ("Tenten", NULL, 17, "Humano", "Naruto", "2000-03-09"),
("Konan", NULL, 35, "Humano", "Naruto", "1982-02-20"), ("Kushina", "Uzumaki", 24, "Humano", "Naruto", "1993-07-10"),
("Karin", NULL, 17, "Humano", "Naruto", "2000-06-20"), ("Mei", "Terumi", 31, "Humano", "Naruto", "1986-05-21"),
("Chiyo", NULL, 70, "Humano", "Naruto", "1947-03-15"), ("Shizune", NULL, 31, "Humano", "Naruto", "1986-11-18"),
("Anko", "Mitarashi", 24, "Humano", "Naruto", "1993-10-24"), ("Kurenai", "Yuhi", 31, "Humano", "Naruto", "1986-06-11"),
("Hanabi", "Hyuga", 10, "Humano", "Naruto", "2007-03-27"),

-- One Piece (20)
("Nami", NULL, 20, "Humano", "One Piece", "1997-07-03"), ("Robin", "Nico", 30, "Humano", "One Piece", "1987-02-06"),
("Boa", "Hancock", 31, "Humano", "One Piece", "1986-09-02"), ("Vivi", "Nefertari", 18, "Humano", "One Piece", "1999-02-02"),
("Tashigi", NULL, 23, "Humano", "One Piece", "1994-10-06"), ("Perona", NULL, 25, "Humano", "One Piece", "1992-06-07"),
("Shirahoshi", NULL, 16, "Humano", "One Piece", "2001-04-04"), ("Rebecca", NULL, 16, "Humano", "One Piece", "2001-08-04"),
("Kaya", NULL, 17, "Humano", "One Piece", "2000-08-24"), ("Nojiko", NULL, 22, "Humano", "One Piece", "1995-07-25"),
("Makino", NULL, 31, "Humano", "One Piece", "1986-02-23"), ("Hina", NULL, 34, "Humano", "One Piece", "1983-03-03"),
("Kalifa", NULL, 27, "Humano", "One Piece", "1990-04-23"), ("Marguerite", NULL, 20, "Humano", "One Piece", "1997-05-05"),
("Camie", NULL, 18, "Humano", "One Piece", "1999-11-02"), ("Bell-mere", NULL, 30, "Humano", "One Piece", "1987-12-03"),
("Koala", NULL, 23, "Humano", "One Piece", "1994-10-25"), ("Carrot", NULL, 15, "Humano", "One Piece", "2002-01-24"),
("Pudding", "Charlotte", 16, "Humano", "One Piece", "2001-06-25"), ("Yamato", NULL, 28, "Humano", "One Piece", "1989-11-03"),

-- Evangelion (10)
("Rei", "Ayanami", 14, "Hibrido", "Neon Genesis Evangelion", "2010-03-30"), ("Asuka", "Langley", 14, "Humano", "Neon Genesis Evangelion", "2010-12-04"),
("Misato", "Katsuragi", 29, "Humano", "Neon Genesis Evangelion", "1988-12-08"), ("Mari", "Makinami", 16, "Humano", "Neon Genesis Evangelion", "2001-06-06"),
("Ritsuko", "Akagi", 30, "Humano", "Neon Genesis Evangelion", "1987-11-21"), ("Maya", "Ibuki", 24, "Humano", "Neon Genesis Evangelion", "1993-05-11"),
("Hikari", "Horaki", 14, "Humano", "Neon Genesis Evangelion", "2010-02-12"), ("Lilith", NULL, NULL, "Desconocido", "Neon Genesis Evangelion", NULL),
("Yui", "Ikari", 27, "Humano", "Neon Genesis Evangelion", "1990-03-30"), ("Kyoko", "Zeppelin", 28, "Humano", "Neon Genesis Evangelion", "1989-04-04"),

-- Steins;Gate (10)
("Mayuri", "Shiina", 16, "Humano", "Steins;Gate", "2001-02-01"), ("Kurisu", "Makise", 18, "Humano", "Steins;Gate", "1999-07-25"),
("Suzuha", "Amane", 18, "Humano", "Steins;Gate", "1999-09-27"), ("Moeka", "Kiryu", 20, "Humano", "Steins;Gate", "1997-06-06"),
("Faris", "NyanNyan", 17, "Humano", "Steins;Gate", "2000-03-03"), ("Ruka", "Urushibara", 16, "Humano", "Steins;Gate", "2001-08-30"),
("Nae", "Tennouji", 11, "Humano", "Steins;Gate", "2006-06-15"), ("Yuki", "Amane", 30, "Humano", "Steins;Gate", "1987-04-04"),
("Kaede", "Kurushima", 25, "Humano", "Steins;Gate", "1992-05-05"), ("Kagari", "Shiina", 10, "Humano", "Steins;Gate", "2007-07-07"),

-- Violet Evergarden (10)
("Violet", "Evergarden", 14, "Humano", "Violet Evergarden", "2010-06-01"), ("Cattleya", "Baudelaire", 24, "Humano", "Violet Evergarden", "1993-05-15"),
("Luculia", "Marlborough", 18, "Humano", "Violet Evergarden", "1999-03-03"), ("Iris", "Canary", 20, "Humano", "Violet Evergarden", "1997-08-08"),
("Clara", "Magnolia", 30, "Humano", "Violet Evergarden", "1987-02-02"), ("Isabella", "York", 16, "Humano", "Violet Evergarden", "2001-04-04"),
("Charlotte", "Abelfreyja", 14, "Humano", "Violet Evergarden", "2003-06-06"), ("Amy", "Bartlett", 15, "Humano", "Violet Evergarden", "2002-03-03"),
("Anne", "Magnolia", 10, "Humano", "Violet Evergarden", "2007-05-05"), ("Erica", "Brown", 22, "Humano", "Violet Evergarden", "1995-07-07"),

-- Blend S (con femboy Hideri) (5)
("Maika", "Sakuranomiya", 16, "Humano", "Blend S", "2001-04-04"), ("Kaho", "Hinata", 17, "Humano", "Blend S", "2000-08-08"),
("Mafuyu", "Hoshikawa", 20, "Humano", "Blend S", "1997-12-12"), ("Miu", "Amano", 23, "Humano", "Blend S", "1994-03-03"),
("Hideri", "Kanzaki", 16, "Humano", "Blend S", "2001-06-06"), -- Femboy

-- Spy x Family (5)
("Yor", "Forger", 27, "Humano", "Spy x Family", "1990-04-06"), ("Anya", "Forger", 6, "Humano", "Spy x Family", "2019-03-03"),
("Becky", "Blackbell", 6, "Humano", "Spy x Family", "2019-02-02"), ("Sylvia", "Sherwood", 35, "Humano", "Spy x Family", "1982-05-05"),
("Fiona", "Frost", 25, "Humano", "Spy x Family", "1992-07-07"),

-- Bleach (15)
("Rukia", "Kuchiki", 150, "espiritu", "Bleach", NULL), ("Orihime", "Inoue", 15, "Humano", "Bleach", "2002-09-03"),
("Yoruichi", "Shihouin", NULL, "espiritu", "Bleach", NULL), ("Rangiku", "Matsumoto", NULL, "espiritu", "Bleach", NULL),
("Nelliel", "Tu Odelschwanck", NULL, "Hibrido", "Bleach", NULL), ("Tatsuki", "Arisawa", 15, "Humano", "Bleach", "2002-07-17"),
("Hiyori", "Sarugaki", NULL, "Hibrido", "Bleach", NULL), ("Soi", "Fon", NULL, "espiritu", "Bleach", NULL),
("Isane", "Kotetsu", NULL, "espiritu", "Bleach", NULL), ("Nemu", "Kurotsuchi", NULL, "Hibrido", "Bleach", NULL),
("Lisa", "Yadoumaru", NULL, "Hibrido", "Bleach", NULL), ("Mashiro", "Kuna", NULL, "Hibrido", "Bleach", NULL),
("Harribel", "Tia", NULL, "Hibrido", "Bleach", NULL), ("Senjumaru", "Shutara", NULL, "espiritu", "Bleach", NULL),
("Unohana", "Retsu", NULL, "espiritu", "Bleach", NULL),

-- Hunter x Hunter (10)
("Bisky", "Krueger", 57, "Humano", "Hunter x Hunter", "1960-02-02"), ("Kurapika", NULL, 19, "Humano", "Hunter x Hunter", "1998-04-04"),
("Machi", "Komacine", 24, "Humano", "Hunter x Hunter", "1993-03-03"), ("Pakunoda", NULL, 28, "Humano", "Hunter x Hunter", "1989-06-06"),
("Shizuku", "Murasaki", 19, "Humano", "Hunter x Hunter", "1998-05-05"), ("Neon", "Nostrade", 16, "Humano", "Hunter x Hunter", "2001-08-08"),
("Palm", "Siberia", 22, "Humano", "Hunter x Hunter", "1995-04-04"), ("Menchi", NULL, 27, "Humano", "Hunter x Hunter", "1990-07-07"),
("Alluka", "Zoldyck", 11, "Humano", "Hunter x Hunter", "2006-03-03"), ("Canary", NULL, 18, "Humano", "Hunter x Hunter", "1999-09-09"),

-- JoJo's Bizarre Adventure (10)
("Jolyne", "Cujoh", 19, "Humano", "JoJo's Bizarre Adventure", "1998-03-03"), ("Trish", "Una", 15, "Humano", "JoJo's Bizarre Adventure", "2002-06-06"),
("Lisa", "Lisa", NULL, "Humano", "JoJo's Bizarre Adventure", NULL), ("Erina", "Pendleton", 20, "Humano", "JoJo's Bizarre Adventure", "1897-03-03"),
("Suzi", "Q", 20, "Humano", "JoJo's Bizarre Adventure", "1917-05-05"), ("Foo", "Fighters", NULL, "Hibrido", "JoJo's Bizarre Adventure", NULL),
("Hermes", "Costello", 23, "Humano", "JoJo's Bizarre Adventure", "1994-04-04"), ("Yasuho", "Hirose", 19, "Humano", "JoJo's Bizarre Adventure", "1998-08-08"),
("Lucy", "Steel", 14, "Humano", "JoJo's Bizarre Adventure", "1897-07-07"), ("Miuccia", "Miuller", 22, "Humano", "JoJo's Bizarre Adventure", "1995-06-06"),

-- Genshin Impact (como anime ficticio) (20)
("Lumine", NULL, NULL, "Humano", "Genshin Impact", NULL), ("Jean", "Gunnhildr", 25, "Humano", "Genshin Impact", "1992-03-14"),
("Lisa", NULL, 28, "Humano", "Genshin Impact", "1989-06-09"), ("Barbara", NULL, 16, "Humano", "Genshin Impact", "2001-07-05"),
("Amber", NULL, 18, "Humano", "Genshin Impact", "1999-08-10"), ("Noelle", NULL, 15, "Humano", "Genshin Impact", "2002-03-21"),
("Fischl", NULL, 16, "Humano", "Genshin Impact", "2001-05-27"), ("Mona", NULL, 19, "Humano", "Genshin Impact", "1998-08-31"),
("Keqing", NULL, 20, "Humano", "Genshin Impact", "1997-11-20"), ("Ningguang", NULL, 25, "Humano", "Genshin Impact", "1992-08-26"),
("Beidou", NULL, 27, "Humano", "Genshin Impact", "1990-02-14"), ("Xinyan", NULL, 16, "Humano", "Genshin Impact", "2001-10-16"),
("Hu Tao", NULL, 19, "Humano", "Genshin Impact", "1998-07-15"), ("Ganyu", NULL, 3000, "Hibrido", "Genshin Impact", NULL),
("Shenhe", NULL, 25, "Humano", "Genshin Impact", "1992-03-10"), ("Yelan", NULL, 24, "Humano", "Genshin Impact", "1993-04-20"),
("Kuki", "Shinobu", 20, "Humano", "Genshin Impact", "1997-05-27"), ("Ei", NULL, NULL, "espiritu", "Genshin Impact", NULL),
("Yae", "Miko", NULL, "espiritu", "Genshin Impact", NULL), ("Kamisato", "Ayaka", 18, "Humano", "Genshin Impact", "1999-09-28"),

-- Kaguya-sama: Love is War (10)
("Kaguya", "Shinomiya", 17, "Humano", "Kaguya-sama: Love is War", "2000-01-01"), ("Chika", "Fujiwara", 16, "Humano", "Kaguya-sama: Love is War", "2001-03-03"),
("Ai", "Hayasaka", 17, "Humano", "Kaguya-sama: Love is War", "2000-04-02"), ("Miko", "Iino", 15, "Humano", "Kaguya-sama: Love is War", "2002-05-05"),
("Nagisa", "Kashiwagi", 17, "Humano", "Kaguya-sama: Love is War", "2000-06-06"), ("Maki", "Shijo", 17, "Humano", "Kaguya-sama: Love is War", "2000-07-07"),
("Kei", "Shirogane", 15, "Humano", "Kaguya-sama: Love is War", "2002-08-08"), ("Moeha", "Fujiwara", 14, "Humano", "Kaguya-sama: Love is War", "2003-09-09"),
("Kobachi", "Osaragi", 15, "Humano", "Kaguya-sama: Love is War", "2002-10-10"), ("Rei", "Onodera", 16, "Humano", "Kaguya-sama: Love is War", "2001-11-11"),

-- Jujutsu Kaisen (15)
("Nobara", "Kugisaki", 16, "Humano", "Jujutsu Kaisen", "2001-08-07"), ("Maki", "Zenin", 16, "Humano", "Jujutsu Kaisen", "2001-01-20"),
("Mai", "Zenin", 16, "Humano", "Jujutsu Kaisen", "2001-01-20"), ("Miwa", "Kasumi", 17, "Humano", "Jujutsu Kaisen", "2000-04-04"),
("Utahime", "Iori", 31, "Humano", "Jujutsu Kaisen", "1986-02-18"), ("Mei", "Mei", 27, "Humano", "Jujutsu Kaisen", "1990-03-03"),
("Tsumiki", "Fushiguro", 18, "Humano", "Jujutsu Kaisen", "1999-06-06"), ("Shoko", "Ieiri", 28, "Humano", "Jujutsu Kaisen", "1989-11-07"),
("Yuki", "Tsukumo", 30, "Humano", "Jujutsu Kaisen", "1987-08-08"), ("Riko", "Amanai", 14, "Humano", "Jujutsu Kaisen", "2003-03-03"),
("Misato", "Kuroi", 25, "Humano", "Jujutsu Kaisen", "1992-04-04"), ("Akari", "Nitta", 23, "Humano", "Jujutsu Kaisen", "1994-05-05"),
("Noritoshi", "Kamo", 18, "Humano", "Jujutsu Kaisen", "1999-07-07"), ("Takada", NULL, 22, "Humano", "Jujutsu Kaisen", "1995-06-06"),
("Panda", NULL, NULL, "Hibrido", "Jujutsu Kaisen", NULL),

-- The Idolmaster (10)
("Haruka", "Amami", 17, "Humano", "The Idolmaster", "2000-04-03"), ("Chihaya", "Kisaragi", 16, "Humano", "The Idolmaster", "2001-02-25"),
("Miki", "Hoshii", 15, "Humano", "The Idolmaster", "2002-11-23"), ("Yukiho", "Hagiwara", 17, "Humano", "The Idolmaster", "2000-12-24"),
("Yayoi", "Takatsuki", 14, "Humano", "The Idolmaster", "2003-03-25"), ("Makoto", "Kikuchi", 17, "Humano", "The Idolmaster", "2000-08-29"),
("Iori", "Minase", 15, "Humano", "The Idolmaster", "2002-05-05"), ("Azusa", "Miura", 21, "Humano", "The Idolmaster", "1996-07-19"),
("Ami", "Futami", 13, "Humano", "The Idolmaster", "2004-05-22"), ("Mami", "Futami", 13, "Humano", "The Idolmaster", "2004-05-22"),

-- Love Live! (15)
("Honoka", "Kosaka", 16, "Humano", "Love Live!", "2001-08-03"), ("Eli", "Ayase", 17, "Humano", "Love Live!", "2000-10-21"),
("Kotori", "Minami", 16, "Humano", "Love Live!", "2001-09-12"), ("Umi", "Sonoda", 16, "Humano", "Love Live!", "2001-03-15"),
("Rin", "Hoshizora", 15, "Humano", "Love Live!", "2002-11-01"), ("Maki", "Nishikino", 16, "Humano", "Love Live!", "2001-04-19"),
("Nozomi", "Tojo", 17, "Humano", "Love Live!", "2000-06-09"), ("Hanayo", "Koizumi", 15, "Humano", "Love Live!", "2002-01-17"),
("Nico", "Yazawa", 17, "Humano", "Love Live!", "2000-07-22"), ("Chika", "Takami", 16, "Humano", "Love Live! Sunshine!!", "2001-08-01"),
("Riko", "Sakurauchi", 16, "Humano", "Love Live! Sunshine!!", "2001-09-19"), ("Kanan", "Matsuura", 17, "Humano", "Love Live! Sunshine!!", "2000-02-10"),
("Dia", "Kurosawa", 17, "Humano", "Love Live! Sunshine!!", "2000-01-01"), ("You", "Watanabe", 16, "Humano", "Love Live! Sunshine!!", "2001-04-17"),
("Yoshiko", "Tsushima", 15, "Humano", "Love Live! Sunshine!!", "2002-07-13"),

-- Kubo Won't Let Me Be Invisible (5)
("Nagisa", "Kubo", 16, "Humano", "Kubo Won't Let Me Be Invisible", "2001-05-05"), ("Akina", "Kubo", 20, "Humano", "Kubo Won't Let Me Be Invisible", "1997-06-06"),
("Saki", "Nagisa", 16, "Humano", "Kubo Won't Let Me Be Invisible", "2001-03-03"), ("Hazuki", "Kudo", 16, "Humano", "Kubo Won't Let Me Be Invisible", "2001-04-04"),
("Tamao", "Tsuchiya", 16, "Humano", "Kubo Won't Let Me Be Invisible", "2001-07-07"),

-- Tonikaku Kawaii (5)
("Tsukasa", "Yuzaki", 18, "Humano", "Tonikaku Kawaii", "1999-04-03"), ("Chitose", "Kaginoji", 14, "Humano", "Tonikaku Kawaii", "2003-08-08"),
("Aurora", NULL, 20, "Humano", "Tonikaku Kawaii", "1997-05-05"), ("Charlotte", NULL, 19, "Humano", "Tonikaku Kawaii", "1998-06-06"),
("Kanoka", "Yuzaki", 40, "Humano", "Tonikaku Kawaii", "1977-03-03"),

-- My Dress-Up Darling (5)
("Marin", "Kitagawa", 16, "Humano", "My Dress-Up Darling", "2001-03-05"), ("Sajuna", "Inui", 17, "Humano", "My Dress-Up Darling", "2000-04-04"),
("Shinju", "Inui", 14, "Humano", "My Dress-Up Darling", "2003-05-05"), ("Amane", NULL, 20, "Humano", "My Dress-Up Darling", "1997-06-06"),
("Kaoru", "Gojou", 40, "Humano", "My Dress-Up Darling", "1977-07-07"),

-- Horimiya (10)
("Kyoko", "Hori", 17, "Humano", "Horimiya", "2000-03-25"), ("Yuki", "Yoshikawa", 17, "Humano", "Horimiya", "2000-04-04"),
("Remi", "Ayasaki", 17, "Humano", "Horimiya", "2000-05-05"), ("Sakura", "Kono", 17, "Humano", "Horimiya", "2000-06-06"),
("Sota", "Hori", 6, "Humano", "Horimiya", "2011-07-07"), ("Yuriko", "Hori", 38, "Humano", "Horimiya", "1979-08-08"),
("Honoka", "Sawada", 16, "Humano", "Horimiya", "2001-09-09"), ("Akane", "Yanagi", 17, "Humano", "Horimiya", "2000-10-10"),
("Kakeru", "Sengoku", 17, "Humano", "Horimiya", "2000-11-11"), ("Toru", "Ishikawa", 17, "Humano", "Horimiya", "2000-12-12"),

-- Miss Kobayashi's Dragon Maid (10)
("Tohru", NULL, NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL), ("Kanna", "Kamui", NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL),
("Elma", NULL, NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL), ("Lucoa", NULL, NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL),
("Ilulu", NULL, NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL), ("Kobayashi", NULL, 25, "Humano", "Miss Kobayashi's Dragon Maid", "1992-04-04"),
("Saikawa", "Riko", 8, "Humano", "Miss Kobayashi's Dragon Maid", "2009-05-05"), ("Fafnir", NULL, NULL, "Demonio", "Miss Kobayashi's Dragon Maid", NULL),
("Shouta", "Magatsuchi", 11, "Humano", "Miss Kobayashi's Dragon Maid", "2006-06-06"), ("Georgie", "Saikawa", 20, "Humano", "Miss Kobayashi's Dragon Maid", "1997-07-07"),

-- Bocchi the Rock! (5)
("Hitori", "Gotou", 16, "Humano", "Bocchi the Rock!", "2001-02-21"), ("Nijika", "Ijichi", 17, "Humano", "Bocchi the Rock!", "2000-05-29"),
("Ryo", "Yamada", 16, "Humano", "Bocchi the Rock!", "2001-09-18"), ("Ikuyo", "Kita", 16, "Humano", "Bocchi the Rock!", "2001-04-21"),
("Seika", "Ijichi", 25, "Humano", "Bocchi the Rock!", "1992-03-03"),

-- Komi Can't Communicate (10)
("Shouko", "Komi", 16, "Humano", "Komi Can't Communicate", "2001-06-06"), ("Najimi", "Osana", 16, "Humano", "Komi Can't Communicate", "2001-07-07"),
("Hitohito", "Tadano", 16, "Humano", "Komi Can't Communicate", "2001-08-08"), ("Ren", "Yamai", 16, "Humano", "Komi Can't Communicate", "2001-09-09"),
("Omoharu", "Nakanaka", 16, "Humano", "Komi Can't Communicate", "2001-10-10"), ("Himiko", "Agari", 16, "Humano", "Komi Can't Communicate", "2001-11-11"),
("Rumiko", "Manbagi", 16, "Humano", "Komi Can't Communicate", "2001-12-12"), ("Chika", "Netsuno", 16, "Humano", "Komi Can't Communicate", "2001-03-03"),
("Naruse", "Shisuto", 16, "Humano", "Komi Can't Communicate", "2001-04-04"), ("Akako", "Onigashima", 16, "Humano", "Komi Can't Communicate", "2001-05-05"),

-- Fullmetal Alchemist (10)
("Winry", "Rockbell", 16, "Humano", "Fullmetal Alchemist", "2001-03-03"), ("Riza", "Hawkeye", 25, "Humano", "Fullmetal Alchemist", "1992-04-04"),
("Izumi", "Curtis", 35, "Humano", "Fullmetal Alchemist", "1982-05-05"), ("Lust", NULL, NULL, "Hibrido", "Fullmetal Alchemist", NULL),
("Lan Fan", NULL, 16, "Humano", "Fullmetal Alchemist", "2001-06-06"), ("Mei", "Chang", 10, "Humano", "Fullmetal Alchemist", "2007-07-07"),
("Olivier", "Armstrong", 37, "Humano", "Fullmetal Alchemist", "1980-08-08"), ("Trisha", "Elric", 26, "Humano", "Fullmetal Alchemist", "1991-09-09"),
("Rose", "Thomas", 18, "Humano", "Fullmetal Alchemist", "1999-10-10"), ("Maria", "Ross", 23, "Humano", "Fullmetal Alchemist", "1994-11-11"),

-- Gintama (10)
("Kagura", NULL, 14, "Humano", "Gintama", "2003-11-03"), ("Tsukuyo", NULL, 22, "Humano", "Gintama", "1995-06-06"),
("Otae", "Shimura", 24, "Humano", "Gintama", "1993-03-03"), ("Kyubei", "Yagyu", 17, "Humano", "Gintama", "2000-04-04"),
("Sarutobi", "Ayame", 25, "Humano", "Gintama", "1992-05-05"), ("Nobume", "Imai", 19, "Humano", "Gintama", "1998-07-07"),
("Mutsu", NULL, 23, "Humano", "Gintama", "1994-08-08"), ("Hinowa", NULL, 28, "Humano", "Gintama", "1989-09-09"),
("Soyo", "Tokugawa", 14, "Humano", "Gintama", "2003-10-10"), ("Matako", "Kijima", 20, "Humano", "Gintama", "1997-11-11"),

-- Clannad (10)
("Nagisa", "Furukawa", 18, "Humano", "Clannad", "1999-12-24"), ("Tomoyo", "Sakagami", 17, "Humano", "Clannad", "2000-10-14"),
("Kyou", "Fujibayashi", 17, "Humano", "Clannad", "2000-05-05"), ("Ryou", "Fujibayashi", 17, "Humano", "Clannad", "2000-05-05"),
("Kotomi", "Ichinose", 18, "Humano", "Clannad", "1999-05-13"), ("Fuko", "Ibuki", 16, "Humano", "Clannad", "2001-06-06"),
("Yukine", "Miyazawa", 17, "Humano", "Clannad", "2000-07-07"), ("Ushio", "Okazaki", 5, "Humano", "Clannad", "2012-08-08"),
("Sanae", "Furukawa", 35, "Humano", "Clannad", "1982-09-09"), ("Mei", "Sunohara", 14, "Humano", "Clannad", "2003-10-10"),

-- Anohana (5)
("Menma", NULL, 15, "espiritu", "Anohana", "2002-03-03"), ("Anaru", "Anjo", 16, "Humano", "Anohana", "2001-04-04"),
("Yukiatsu", "Matsuyuki", 16, "Humano", "Anohana", "2001-05-05"), ("Tsuruko", "Tsukioka", 16, "Humano", "Anohana", "2001-06-06"),
("Poppo", "Hisakawa", 16, "Humano", "Anohana", "2001-07-07"),

-- Your Name (5)
("Mitsuha", "Miyamizu", 17, "Humano", "Your Name", "2000-09-01"), ("Taki", "Tachibana", 17, "Humano", "Your Name", "2000-08-08"),
("Sayaka", "Natori", 17, "Humano", "Your Name", "2000-06-06"), ("Yotsuha", "Miyamizu", 11, "Humano", "Your Name", "2006-07-07"),
("Hitoha", "Miyamizu", 60, "Humano", "Your Name", "1957-03-03"),

-- Puella Magi Madoka Magica (10)
("Madoka", "Kaname", 14, "Humano", "Puella Magi Madoka Magica", "2003-10-03"), ("Homura", "Akemi", 14, "Humano", "Puella Magi Madoka Magica", "2003-05-05"),
("Sayaka", "Miki", 14, "Humano", "Puella Magi Madoka Magica", "2003-06-06"), ("Mami", "Tomoe", 15, "Humano", "Puella Magi Madoka Magica", "2002-07-07"),
("Kyoko", "Sakura", 14, "Humano", "Puella Magi Madoka Magica", "2003-08-08"), ("Nagisa", "Momoe", 10, "Hibrido", "Puella Magi Madoka Magica", "2007-09-09"),
("Kyubey", NULL, NULL, "Desconocido", "Puella Magi Madoka Magica", NULL), ("Hitomi", "Shizuki", 14, "Humano", "Puella Magi Madoka Magica", "2003-03-03"),
("Junko", "Kaname", 35, "Humano", "Puella Magi Madoka Magica", "1982-04-04"), ("Tatsuya", "Kaname", 3, "Humano", "Puella Magi Madoka Magica", "2014-05-05"),

-- Sailor Moon (10)
("Usagi", "Tsukino", 14, "Humano", "Sailor Moon", "2003-06-30"), ("Ami", "Mizuno", 14, "Humano", "Sailor Moon", "2003-09-10"),
("Rei", "Hino", 14, "Humano", "Sailor Moon", "2003-04-17"), ("Makoto", "Kino", 14, "Humano", "Sailor Moon", "2003-12-05"),
("Minako", "Aino", 14, "Humano", "Sailor Moon", "2003-10-22"), ("Chibiusa", NULL, 6, "Humano", "Sailor Moon", "2011-06-30"),
("Setsuna", "Meioh", 19, "Humano", "Sailor Moon", "1998-10-29"), ("Haruka", "Tenoh", 16, "Humano", "Sailor Moon", "2001-01-27"),
("Michiru", "Kaioh", 16, "Humano", "Sailor Moon", "2001-03-06"), ("Hotaru", "Tomoe", 12, "Humano", "Sailor Moon", "2005-01-06"),

-- Cardcaptor Sakura (5)
("Sakura", "Kinomoto", 10, "Humano", "Cardcaptor Sakura", "2007-04-01"), ("Tomoyo", "Daidouji", 10, "Humano", "Cardcaptor Sakura", "2007-09-03"),
("Meiling", "Li", 10, "Humano", "Cardcaptor Sakura", "2007-03-03"), ("Nadeshiko", "Kinomoto", 27, "Humano", "Cardcaptor Sakura", "1990-05-05"),
("Kaho", "Mizuki", 25, "Humano", "Cardcaptor Sakura", "1992-06-06"),

-- Death Note (5)
("Misa", "Amane", 19, "Humano", "Death Note", "1998-12-25"), ("Kiyomi", "Takada", 24, "Humano", "Death Note", "1993-07-12"),
("Naomi", "Misora", 27, "Humano", "Death Note", "1990-02-11"), ("Sayu", "Yagami", 14, "Humano", "Death Note", "2003-06-18"),
("Sachiko", "Yagami", 45, "Humano", "Death Note", "1972-03-03"),

-- Code Geass (10)
("C.C.", NULL, NULL, "Desconocido", "Code Geass", NULL), ("Lelouch", "Lamperouge", 17, "Humano", "Code Geass", "2000-12-05"),
("Kallen", "Kozuki", 17, "Humano", "Code Geass", "2000-03-29"), ("Shirley", "Fenette", 17, "Humano", "Code Geass", "2000-07-08"),
("Nunnally", "Lamperouge", 14, "Humano", "Code Geass", "2003-10-25"), ("Euphemia", "li Britannia", 16, "Humano", "Code Geass", "2001-10-11"),
("Cornelia", "li Britannia", 27, "Humano", "Code Geass", "1990-04-04"), ("Milly", "Ashford", 18, "Humano", "Code Geass", "1999-05-05"),
("Villetta", "Nu", 25, "Humano", "Code Geass", "1992-06-06"), ("Marianne", "vi Britannia", 35, "Humano", "Code Geass", "1982-07-07"),

-- Kill la Kill (5)
("Ryuko", "Matoi", 17, "Humano", "Kill la Kill", "2000-10-03"), ("Satsuki", "Kiryuin", 18, "Humano", "Kill la Kill", "1999-11-11"),
("Mako", "Mankanshoku", 17, "Humano", "Kill la Kill", "2000-12-12"), ("Nui", "Harime", NULL, "Hibrido", "Kill la Kill", NULL),
("Ragyo", "Kiryuin", 40, "Humano", "Kill la Kill", "1977-03-03"),

-- Neon Genesis Evangelion (extras para completar)
("Mana", "Kirishima", 14, "Humano", "Neon Genesis Evangelion", "2003-04-04"), ("Kodama", "Horaki", 20, "Humano", "Neon Genesis Evangelion", "1997-05-05"),
("Nozomi", "Horaki", 10, "Humano", "Neon Genesis Evangelion", "2007-06-06");