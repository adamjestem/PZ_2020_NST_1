# PZ_2020_NST_1

* Architektura aplikacji to aplikacja cebulowa https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/ 

* Flow jest takie mniej wiecej:
    1. Scena która jest w folderze flow wyświetla UI (plik fxml kończący się …Scene + klasa kończąca się na …Controller) i komunikuje się z serwisami
    2. Serwis albo wywołuje inne serwisy albo wywołuje plik repository
    3. Repository używa persistence albo SQL do komunikacji z baza danych
* Jako, że w aplikacji nie ma DependecyContainer to każdy serwis, repository itp. musi mieć statyczna mętodę inject która zwraca instancję klasy (w kodzie który dodałem są przykłady jak robić singletony i jak robić serwisy które mają wiele instancji. singleton - Router.java, wiele - BuildingsService)
* Jeżeli chcemy sobie wstrzyknąć instancję jakiejś innej klasy to robimy to poprzez deklarację w klasie pola prywatnego final i ustawienie referencji do tej klasy poprzez factory method np:
```private final Router router = Router.inject();```
*  dodajemy jakiś widok który jest Routowalny to dodajemy wpis do: Flow.java, FlowRepository.java - gdzie jest słownik nazwa Flow i nazwa pliku fxml, Route.java, Routes.java. Dodajemy obsługę ścieżki w Router.java (edited) 
* Jeżeli chcemy przejść na jakiś widok używamy klasy Router i metody goTo, e.g.
    ```
    try {
        this.router.goTo(Route.DASHBOARD);
    } catch (IOException exception) {
         // show some alert
    }
    ```
* Wszystkie dane dot. sesji tego, czy user jest zalogowany. Trzymane jest (lub ma być) w klasie SessionManager
* Jeżeli robi się zmianę w jednym z modeli domenowych TRZEBA zmienić też `dump.sql` i `dane.sql`
