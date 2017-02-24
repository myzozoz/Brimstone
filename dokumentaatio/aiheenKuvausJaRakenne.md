#Brimstone

**Aihe**: Brimstone on ylhäältä-alaspäin perspektiivissä kuvattu toimintapeli. Pelin ideana on tyhjentää kartta vihollisista ja mahdollisista muista vihollisista. Tämä tehdään käyttämällä hyväksi pelaajan hahmon eri suuntiin ampumia liekkejä, joiden kantaman määrittelee pelaajan nopeus. Eli jos pelaaja liikkuu nopeasti, on liekitkin tehokkaampia, pysähtyessä ne sammuvat. 

**Pelaajan toiminnot**: Pelaajan pääavut toimintaan ovat liikkumiseen tarkoitetut näppäimet, eli todennäköisimmin nuolinäppäimet. Laajennusmahdollisuutena pelaajalle voi antaa esineitä, joita varten voisi olla oma aktivointinäppäimensä (esim. välilyönti). Käyttäen liikkumista hyväkseen, pelaajan pitää suorittaa pelin antamat tehtävät


![Luokkakaavio](BrimstoneClassDiagram.png "Luokkakaavio")

![Sekvenssikaavio](Sekvenssikaavio.png "Sekvenssikaavio 1)

![Sekvenssikaavio](Sekvenssikaavio2.png "Sekvenssikaavio 2)

**Rakennekuvaus**: Kaikkea pyörittää Game -luokka. Game:lla on luokkamuuttujina tallennettu sekä logiikkapuolen MapController, että käyttöliittymäpuolen FrameInit, Painter ja DirectionListener. Game omistaa myös loopin, joka jokaisella suorituskerralla kutsuu MapControllerin mapUpdatea, sekä sitten kälin päivitystä. MapController taas sisältää pelaajan, viholliset, kartalle sijoitettavat seinät, sekä itse tason. Näitä olioita muokkaavat metodit kuitenkin ovat erillisessä Updater -luokassa, joka sisältää ainoastaa staattisia metodeja.

Updaterin kaverina on sitten helper-paketissa kohtuullisen geneerinen CollisionManager, joka pystyy laskemaan minkä tahansa kahden MapObject -rajapinnan täyttävän luokan yhteentörmäyksiä. Sen lisäksi se pystyy laskemaan esim. pelaajan kimmotuksia seinistä. Player laskee kuitenkin lähtökohtaisesti omat liikkeensä, kuten kiihdytyksen. 
