###Testausdokumentti

#Testaamatta jäi
- Kaikki käyttöliittymäluokat
- Game -luokan metodit, sillä ne ovat privaatteja. Luokan ainoa julkinen metodi on Konstruktori. Nämä metodit ovat myös kovin yksinkertaisia.
- Osa Updater -luokan metodeista, sillä nekin ovat privaatteja.
- Käytännössä kaikki setterit ja getterit.
- Flame luokka on niin simppeli, että sille ei ollut varsinaisesti järkeä tehdä omia testejä.
- MapControllerin spawnEnemies() -metodi

#Testasin näitä
- Pelaamalla itse peliä.
- Tein välillä myös konsoliin ilmestyviä testitulostuksia, jotka auttoivat debugaamaan joitain tilanteita.
- Varsinkin Updaterin metodeja tarkistin kiinnittämällä huomiota pelin toimintaan. Tässä tilanteessa juuri pelin toimivuus oli tärkeämpää, kuin tarkat luvut.

#Bugeja
- Demon jälkeen ilmestyi outo bugi joka liittyy graafiseen käyttöliittymään. Liekit eivät tulostu ruudulle nätisti, vaan välkkyvät ja heiluvat, mahdollisesti eivät ehdi jokaiselle piirtokerralle päivittyä
- Vihollisten liikettä ei ole tasattu delta-ajan kanssa, sillä kun yritin tätä implementoida, syntyivät viholliset aina kartan ulkopuolelle.
- Vihollinen voi syntyä seinän sisään, jolloin se ei pääse liikkumaan. Sen voi kuitenkin tappaa, jolloin peli jatkuu.
- Jos osut seinä-palikkaan suoraan kulmasta käsin, pomppaat tasan vastakkaiseen suuntaan, mikä saattaa johtaa siihen, että pomppaat hieman epäintuitiivisesti seinästä.
