
# Wybory parlamentarne (ang. Parliamentary Elections)


Program symuluje przeprowadzenie procesu wyborczego w wyimaginowanym kraju Bajtocja.
Na ten proces składa się: formowania okręgów wyborczych, kampania wyborczej, 
głosowanie oraz przeliczania głosów na mandaty trzema różnymi metodami. 


(ang. The program simulates a parliamentary elections in an imaginary country called Byteland.
      This process consists of: formation of constituencies, election campaign, 
      voting and converting votes into seats using three different methods.)


## Zasady przeprowadzania wyborów w Bajtocji
W Bajtocji odbywają się wybory posłów do Bajtockiego Parlamentu. 

### Okręgi wyborcze

Bajtocja jest podzielona na `n podstawowych okręgów wyborczych` o numerach 1,2,3,...,n. 
W każdym podstawowym okręgu wyborczym znajduje się `określona liczba wyborców`, przyjmujemy, że zawsze jest
ona wielokrotnością 10. Okręgi wyborcze mogą być jednak łączone (jedynie o sąsiednich numerach i każdy okręg może być
połączony z tylko jednym innym). 

### Kandydaci do parlamentu

W każdym okręgu wyborczym wybierana jest liczba `posłów do parlamentu` równa n/10, gdzie n to liczba wyborców w danym okręgu. 
Przyjmujemy, że każda `partia w danym okręgu`
wystawia dokładnie tylu kandydatów, ile jest do obsadzenia mandatów, licząc na zdobycie
wszystkich mandatów, każdy kandydat jest wybierany tylko w 1 okręgu, a wyborcy w danym
okręgu mogą głosować tylko na kandydatów z danego okręgu.

Każdy `kandydat do parlamentu` ma imię, nazwisko, przynależność do danej partii politycznej
oraz okręgu wyborczego, numer na liście wyborczej partii w danym okręgu oraz pewną
liczbę cech, których wartości są całkowite i są w przedziale od -100 do 100.

### Wyborcy

Wyborców możemy podzielić na kilka typów w zależności od tego, czym kierują się przy podejmowaniu decyzji co do
wyboru kandydata:
1. `Żelazny partyjny` zawsze głosuje na losowego kandydata na liście danej
partii.
2. `Żelazny kandydata` zawsze głosuje na danego kandydata.
3. `Minimalizujący jednocechowy` wybiera tego spośród kandydatów wszystkich partii,
który ma najniższy poziom wybranej przez niego cechy (jeśli taką wartość ma więcej
niż 1 kandydat, to wybór kandydata jest losowy).
4. `Maksymalizujący jednocechowy` wybiera tego spośród kandydatów wszystkich partii,
który ma najwyższy poziom wybranej przez niego cechy (jeśli taką wartość ma więcej
niż 1 kandydat, to wybór kandydata jest losowy).
5. `Wszechstronny` liczy sumę ważoną cech dla każdego z kandydatów, przypisując
każdej z jego cech całkowite wagi (które zawsze powinny być z przedziału -100 do
100)ze swojego wektora wag, a następnie dokonuje wyboru maksymalizując sumę
ważoną.

6. Istnieją także wyborcy, którzy działają `zgodnie z jedną ze strategii z punktów 3,4,5`,
ale przy dokonywaniu wyboru `ograniczają się do jednej partii`.

### Przebieg wyborów

Każdy wyborca `oddaje głos` na dokładnie 1 kandydata (z własnego okręgu wyborczego).
Głosy wszystkich wyborców z danego okręgu wyborczego są następnie `sumowane` i
`zamieniane na mandaty`. 

Dopuszcza się 3 `metody zamiany głosów na mandaty`:
1. Metoda D'Hondta
2. Metoda Sainte-Laguë
3. Metoda Hare’a-Niemeyera

### Kampania wyborcza

Przed wyborami odbywa się kampania wyborcza, na którą każda z partii ma określony
budżet (każda partia może mieć inny budżet). 

Za pieniądze z budżetu partie mogą podejmować `działania oddziałujące na wyborców`, każde z
działań ma swoją `cenę` oraz `opis`, który jest reprezentowany jako wektor opisujący jak
zmieniają się `wagi cech`. 

Każde działanie może `zwiększyć lub zmniejszyć wagę każdej
cechy` u każdego z wyborców o wartość całkowitą z określonego przedziału od -z do z (nie
przekraczając jednak minimalnych i maksymalnych wartości wag), te liczby są właśnie na
pozycjach w wektorze opisującym zmianę wag i mogą być różne dla różnych cech. 
Za jednym razem partia może wykonać działanie tylko w jednym okręgu wyborczym. 

`Koszt` jaki partia musi ponieść za dane działanie jest równy sumie
wartości bezwzględnych wektora zmiany wag * liczba wszystkich wyborców w danym okręgu
wyborczym. Partie wykonują działania tak długo, jak długo pozwala im na to budżet.

Partie mogą mieć różne strategie, np.:
1. są partie działające `“z rozmachem”`, które zawsze wybierają najdroższe możliwe
działanie (na które pozwala im budżet)
2. są partie działające `“skromnie”`, które zawsze wybierają najtańsze możliwe działanie
3. są partie działające `“zachłannie”`, starają się wybierać takie działanie, które w
największym stopniu zwiększy sumę sum ważonych cech swoich kandydatów w
danym okręgu wyborczym


## Działanie programu

### Wejście
Program wczytuje
wszystkie parametry z plików wejściowych (i ścieżka do pliku wejściowego jest jedynym
argumentem programu). 

Format pliku wejściowego:

#### 1)
Pierwszy wiersz zawiera `cztery liczby`:

- n - liczba podstawowych okręgów wyborczych 
- p - liczba partii 
- d - liczba możliwych działań 
- c - liczba cech kandydatów 

#### 2)
 Drugi wiersz zawiera:
 - `liczbę par podstawowych okręgów wyborczych`, które należy `scalić`  
 - Następnie tyle właśnie par postaci (o,o+1)

#### 3)
Trzeci wiersz zawiera p `nazw partii` 

#### 4)
Czwarty wiersz zawiera p liczb  określających `budżety` poszczególnych partii

#### 5)
Piąty wiersz składa się z p znaków odpowiadających `strategiom` poszczególnych partii 
- ‘R’ - partia działa “z rozmachem”
- ‘S’ - partia działa “skromnie”
- ‘W’ - partia korzysta z dodatkowej strategii zaimplementowanej przez Ciebie
- ‘Z’ - partia działa “zachłannie”

#### 6)
Szósty wiersz zawiera n liczb postaci 10k - są to `liczby wyborców` w każdym podstawowym okręgu wyborczym

#### 7)
W kolejnych wierszach są opisy poszczególnych `kandydatów`
- Każdy kandydat jest w
osobnym wierszu, 
- kandydaci są pogrupowani okręgami (zgodnie z ich rosnącymi
numerami), w ramach okręgu partiami (kolejność partii taka sama jak podana
wcześniej), a w ramach partii występują w pliku zgodnie z rosnącą pozycją na liście.
- Każdy wiersz ma postać: `imię` `nazwisko` `numer_okręgu` `nazwa_partii` `pozycja_na_liscie` `w1 w2 … wc`
- `w1 w2 … wc` to wartości cech (liczby całkowite z
przedziału [-100, 100]). 

#### 8)
Kolejne wiersze zawierają opis wyborców, 
- jeden wiersz zawiera opis jednego wyborcy, 
- najpierw wypisani są wszyscy wyborcy z okręgu 1, potem wszyscy wyborcy
z okręgu 2, itd. 
- Każdy wiersz zawiera `imię`, `nazwisko`, `numer podstawowego okręgu
wyborczego` oraz `typ wyborcy`, 
- Typ wyborcy jest reprezentowany jako liczba:

```
1 - Żelazny elektorat partyjny
2 - Żelazny elektorat kandydata
3 - Minimalizujący jednocechowy wybierający spośród wszystkich partii
4 - Maksymalizujący jednocechowy wybierający spośród wszystkich partii
5 - Wszechstronny wybierający spośród wszystkich partii
6 - Minimalizujący jednocechowy wybierający spośród jednej partii
7 - Maksymalizujący jednocechowy wybierający spośród jednej partii
8 - Wszechstronny wybierający spośród jednej partii
```
 - W przypadku wyborców typu 1 i 2 w tym samym wierszu mamy jeszcze nazwę partii, 
 - W przypadku wyborców typu 2 dodatkowo jeszcze pozycję
kandydata na liście partii 
 - W przypadku wyborców typu 5 i 8 mamy za to wartości bazowe wag,
które dany wyborca przypisuje poszczególnym cechom kandydatów: w1, w2, …, wc

 - W przypadku wyborców typu 8 na końcu (po wagach) powinna być jeszcze nazwa
partii. 
 - W przypadku wyborców typu 3,4,6,7 po typie jest natomiast
liczba, określająca która wartość cechy kandydatów powinna być
maksymalizowana / minimalizowana, a w przypadku wyborców typu 6 i 7 potem jest
jeszcze nazwa partii.

#### 9)

W kolejnych d wierszach jest `opis możliwych działań`, każdy wiersz zawiera c liczb
całkowitych określających jak
zmieniają się wartości każdej spośród c wag poszczególnych cech kandydatów w
okręgu wyborczym, w którym zastosowano dane działanie.


#### Przyjmujemy poprawność danych wejściowych.


### Wyjście
W wyniku dla każdej z 3 metod przeliczania głosów na mandaty program wypisuje
w kolejnych wierszach:

`1.` Nazwę metody przeliczania głosów

`2.` Dla każdego okręgu wyborczego 

-  nr okręgu wyborczego 
-  imię i nazwisko wyborcy, imię i nazwisko kandydata, na którego głosował 
-  imię i nazwisko kandydata, jego partię i numer na liście oraz łączną liczbę
głosów na niego 
-  ciąg następujcych par: `nazwa partii`, `liczba mandatów z danego okręgu`.

`3.` Łącznie (dla wszystkich okręgów): ciąg par `nazwa partii`, `liczba mandatów ze
wszystkich okręgów`
