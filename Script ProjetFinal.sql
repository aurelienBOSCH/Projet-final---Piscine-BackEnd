create database if not exists projet_final_piscine;
use projet_final_piscine;

-- INSERTION DES DONNEES DE PLANNING
insert into planning(horaire_debut_journee, horaire_fin_journee)values 
("2022-06-20 08:00:00", "2022-06-20 20:00:00"), #LUNDI
("2022-06-21 08:00:00", "2022-06-20 20:00:00"),
("2022-06-22 08:00:00", "2022-06-20 20:00:00"),
("2022-06-23 08:00:00", "2022-06-20 20:00:00"),
("2022-06-24 08:00:00", "2022-06-20 20:00:00"),
("2022-06-25 08:00:00", "2022-06-20 16:00:00"); #SAMEDI

-- INSERTION DES DONNEES DES ACTIVITES
insert into activite(horaire_debut, horaire_fin, nbr_places, nom_activite, prix, id_planning) values 
('2022-06-20 10:00:00', '2022-06-20 12:00:00', 20, "Aquabike", 10, 1),
('2022-06-20 14:00:00', '2022-06-20 16:00:00', 20, "Aquabike", 11, 1),
('2022-06-22 16:00:00', '2022-06-22 18:00:00', 20, "Aquabike", 10, 3),
--
('2022-06-20 08:00:00', '2022-06-20 10:00:00', 20, "Aquagym", 10, 1),
('2022-06-22 10:00:00', '2022-06-22 12:00:00', 20, "Aquagym", 10, 3),
('2022-06-23 08:00:00', '2022-06-23 10:00:00', 20, "Aquagym", 10, 4),
('2022-06-24 10:00:00', '2022-06-24 12:00:00', 20, "Aquagym", 10, 5),
--
('2022-06-21 10:00:00', '2022-06-21 12:00:00', 30, "Water run", 15, 2),
('2022-06-22 12:00:00', '2022-06-22 14:00:00', 30, "Water run", 15, 3),
('2022-06-23 10:00:00', '2022-06-23 12:00:00', 30, "Water run", 15, 4),
('2022-06-24 08:00:00', '2022-06-24 10:00:00', 30, "Water run", 15, 5),
--
('2022-06-20 18:00:00', '2022-06-20 20:00:00', 5, "Lecon personnelle", 16, 1),
('2022-06-21 16:00:00', '2022-06-21 18:00:00', 5, "Lecon personnelle", 16, 2),
('2022-06-22 18:00:00', '2022-06-22 20:00:00', 5, "Lecon personnelle", 16, 3),
('2022-06-23 14:00:00', '2022-06-23 16:00:00', 5, "Lecon personnelle", 16, 4),
('2022-06-24 14:00:00', '2022-06-24 16:00:00', 5, "Lecon personnelle", 16, 5),
--
('2022-06-21 08:00:00', '2022-06-21 10:00:00', 20, "Aqua Crossfit", 8, 2),
('2022-06-22 08:00:00', '2022-06-22 10:00:00', 20, "Aqua Crossfit", 8, 3),
('2022-06-22 14:00:00', '2022-06-22 16:00:00', 20, "Aqua Crossfit", 8, 3),
('2022-06-25 08:00:00', '2022-06-25 10:00:00', 20, "Aqua Crossfit", 8, 6),
--
('2022-06-21 14:00:00', '2022-06-21 16:00:00', 20, "Yoga", 12, 2),
('2022-06-23 16:00:00', '2022-06-23 18:00:00', 20, "Yoga", 12, 4),
('2022-06-25 10:00:00', '2022-06-25 12:00:00', 20, "Yoga", 14, 6),
--
('2022-06-20 12:00:00', '2022-06-20 14:00:00', 15, "Natation Maternite", 12, 1),
('2022-06-21 12:00:00', '2022-06-21 14:00:00', 15, "Natation Maternite", 12, 2),
('2022-06-23 12:00:00', '2022-06-23 14:00:00', 15, "Natation Maternite", 12, 4),
('2022-06-24 12:00:00', '2022-06-24 14:00:00', 15, "Natation Maternite", 12, 5),
('2022-06-25 12:00:00', '2022-06-25 14:00:00', 15, "Natation Maternite", 12, 6),
--
('2022-06-20 16:00:00', '2022-06-20 18:00:00', 25, "Aquafusion", 11, 1),
('2022-06-24 16:00:00', '2022-06-24 18:00:00', 25, "Aquafusion", 11, 5),
('2022-06-25 14:00:00', '2022-06-25 16:00:00', 25, "Aquafusion", 11, 6),
--
('2022-06-21 18:00:00', '2022-06-21 20:00:00', 14, "Waterpolo", 15, 2),
('2022-06-23 18:00:00', '2022-06-23 20:00:00', 14, "Waterpolo", 15, 4),
('2022-06-24 18:00:00', '2022-06-24 20:00:00', 14, "Waterpolo", 15, 5);


-- INSERTION DES DONNEES DES MATERIELS
insert into materiel(nom_materiel, qt_materiel) values 
("Velo", 15),
("Ballon", 10),
("Bouée", 20),
("Bonnet", 20),
("Frite", 30),
("Flotteurs", 30),
("Tapis de course", 15),
("Tapis", 50),
("Poids", 40),
("Brassards", 60),
("Filet", 5),
("Paires de Raquette",20);

-- INSERTION DES PERSONNES
INSERT INTO personne(nom, prenom, telephone, email, password, date_naissance, role, type_abonnement, username, adresse) values 
("Zurie", "Bélanger", "05.11.07.88.84", "ZurieBelanger@jourrapide.com", "de3UchaW", '1972-08-25', "client", "mensuel", "Whoas1972", "4, boulevard d'Alsace"),
("Christien", "Melanson", "02.86.37.60.97", "ChristienMelanson@dayrep.com", "Eis9sahfae", '1963-11-09', "client", "hebdomadaire", "Tral1963", "67, Avenue De Marlioz"),
("Alexandrie", "Majory", "02.63.71.76.02", "AlexandrieMajory@jourrapide.com", "mahl9Mus", '1945-08-30', "client", "annuel", "pretzelfreethrow", "24, avenue Jean Portalis"),
("Algernon", "Rousseau", "01.88.12.94.37", "AlgernonRousseau@armyspy.com", "aeB2oiWu0A", '1965-09-30', "client", "annuel", "kiltstaking", "chemin de Simon"),
("Marguerite", "Courtemanche", "01.09.18.74.54", "MargueriteCourtemanche@dayrep.com", "Ohpois7vo", '1985-10-30', "client", "annuel", "ediblegirlfriend", "29, rue Astrid Adam"),
("Vick", "Lavoie", "03.87.06.76.43", "VickLavoie@armyspy.com", "eiLeanae6zie", '1951-03-30', "client", "hebdomadaire", "infantileclassic", "45, place Julie Duval"),
("Josephe", "Étoile", "01.59.64.85.11", "JosepheEtoile@dayrep.com", "ahY2Leth", '1964-05-30', "client", "mensuel", "creakelectric", "3, rue de Pereira"),
("Andrée", "Laderoute", "03.67.33.75.30", "AndreeLaderoute@armyspy.com", "ohPe9ooxuNai", '1982-04-30', "client", "annuel", "electricsew", "19, avenue Édouard Morin"),
("Renée", "Turcotte", "04.96.28.43.72", "ReneeTurcotte@armyspy.com", "Sheegio4eiz", '1980-03-30', "client", "annuel", "creaklincoln", "37, rue Morin"),
("Troy", "Guimond", "01.22.29.99.78", "TroyGuimond@jourrapide.com", "Tahph1wech", '1995-01-30', "client", "hebdomadaire", "wheredoofus", "boulevard Isabelle Chretien"),
("Troy", "Dandonneau", "01.28.49.64.04", "TroyDandonneau@rhyta.com", "eiTai2Wee", '1996-08-30', "client", "hebdomadaire", "aboardmoderate", "7, chemin Richard"),
("Landers", "Mercure", "01.84.94.01.53", "LandersMercure@rhyta.com", "aij1iugahPh", '1990-08-30', "client", "mensuel", "victoriouscupid", "84, avenue Tristan Guillet"),
("Gill", "Duperré", "01.68.52.49.71", "GillDuperre@dayrep.com", "nohu8weCoo", '2000-09-30', "client", "annuel", "oryxornate", "271, avenue de Simon"),
("Yolande", "Devoe", "03.82.56.90.94", "YolandeDevoe@teleworm.us", "Gie3jeengoo", '2002-10-30', "client", "annuel", "fossildepending", "538, impasse de Riou"),
("Fifi", "Trépanier", "04.32.28.44.02", "FifiTrepanier@rhyta.com", "Dieh1sahw", '1999-11-30', "client", "mensuel", "herringposition", "63, avenue Leroux"),
("Tristan", "Gauthier", "03.98.75.36.47", "zlemaire@free.fr", "Lf3xD&wx", '1987-05-12', "admin", "annuel", "evrard.laurent", "23, place Loiseau"),
("Émilie", "de Renaud", "05.25.21.37.86", "andre.corinne@tiscali.fr", "wx?T^s|j2", '1985-09-22', "admin", "annuel", "lejeune.guy", "68, avenue Antoinette Lamy"),
("Julie", "Merle", "02.74.82.05.33", "hebert.michele@free.fr", "s%U}voNM:O)x3m&", '1970-10-01', "admin", "annuel", "yves.marechal", "58, avenue de Leduc"),
("Aurore", "Charrier", "04.50.93.80.84", "xjoubert@camus.fr", "X6;rorCz?Pi[Z", '1982-01-05', "admin", "annuel", "emilie94", "77, place Schmitt"),
("Antoinette", "Buisson-Traore", "09.54.50.70.42", "william.bazin@mendes.com", "tq)x5KZg", '2001-07-22', "admin", "annuel", "marguerite46", "421, chemin Gilles Fouquet"),
("Noël", "Raynaud", "01.04.23.30.82", "bernadette.seguin@hotmail.fr", "79=@-3sm9C3-eK", '1994-09-06', "admin", "annuel", "tessier.gabriel", "7, rue de Samson"),
("Julien", "Gauthier-Boutin", "08.95.32.37.86", "pbrun@club-internet.fr", "i;s5!6{<&i9/^$pH`E6F", '2000-10-10', "encadrant", "annuel", "luce.bouchet", "chemin Émilie Payet"),
("Claire", "Bazin", "07.32.54.24.74", "anouk.gimenez@sfr.fr", "n0g3tv,Y", '1992-11-03', "encadrant", "annuel", "michaud.alex", "58, boulevard de Guilbert"),
("Virginie", "Leveque-Ollivier", "05.52.93.00.49", "lombard.agathe@noos.fr", "]Dcn]", '1980-03-14', "encadrant", "annuel", "aurore.payet", "7, avenue Masson"),
("Philippe", "du Bonnet", "08.93.92.53.82", "stephane98@example.net", "4L8W3RNFu5[Y", '1981-05-30', "encadrant", "annuel", "veronique.moulin", "341, chemin de Marty"),
("Stéphanie", "Coste", "05.49.88.54.29", "emoreau@lefebvre.fr", "EH2m~Sb-scjh%[(", '1984-02-19', "encadrant", "annuel", "emmanuelle73", "9, rue de Da Costa"),
("Émile", "Clerc-Gimenez", "05.00.40.68.18", "christiane.laroche@vidal.com", "zT9317ON)WY|", '1996-01-15', "encadrant", "annuel", "vallee.valerie", "87, avenue Alexandre Lemaitre"),
("Cécile-Lucie", "Schmitt", "06.67.22.04.89", "isabelle.guillou@example.org", "?}k-(g", '2000-06-30', "encadrant", "annuel", "benjamin24", "8, avenue Margaud Huet"),
("Linda","C. Hodges", "05.56.47.77.34", "MarcDJones@rhyta.com", "Ef4Pheiw", '1981-12-30', "client", "annuel", "Drete1963", "23, place Loiseau");

