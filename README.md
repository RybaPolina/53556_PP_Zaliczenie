System zarządzania zadaniami w zespole

Polina Rybachuk 53556

Spis treści:
1. Folder "src" - Kod źródłowy programu
   1. List Window (Folder) - GUI głównego okna programu (znajduje się również w nim metoda main)
   2. TaskEditPupUp (Folder) - GUI Pop-up do edycji zadań
   3. Task - kod do zarządznia zadaniami
   4. Employee - kod do zarządzania pracownikami
   5. Modele:
      1. EmployeeTableModel - model tabeli pracowników 
      2. TasksTableModel - model tabeli zadań
      3. EmployeeComboBoxModel - model pola wyboru pracownika
      4. Calendar - dane do pół wyboru dat
   6. META-INF - plik techniczny do artefaktu .jar
2. Folder "build" - Znajduje się w nim plik ze zbuildowanym programem
3. Foldery ".idea" oraz "out" są technicznymi folderami InteliJ


FUNKCJONALNOŚĆ
1. Aplikacja pozwala dodać nowego pracownika wpisując imię, nazwisko oraz stanowisko w formularzu
2. Po dodaniu pracownika aplikacja wyświetla w tabeli wyżej dane wszystkich pracowników oraz informację ile każdy pracownik ma przypisanych zadań. 
3. Aplikacja pozwala dodać nowe zadanie wpisując jego nazwę, przypisując pracownika (nowo dodany pracownik również będzie dostępny do wyboru), status oraz datę zakończenia (UWAGA, aplikacja nie pozwala na stworzenie zadania jeżeli nie został przypisany żaden pracownik)
4. Po dodaniu zadania aplikacja wyświetla w tabeli wyżej informację o wszystkich zadaniach + statystyki takie jak data utworzenia zadania oraz informacja ile ma pracownik czasu na jego wykonanie (w oparciu o ustawiony termin oddania)
5. Po podwójnym kliknięciu w zadanie wyświetla się pop-up który pozwala edytować zadanie (można zmienić nazwę, status, zmienić pracownika i datę oddania)
6. Jeżeli do pracownika zostało przypisane zadanie w tabeli pracowników zaktualizuje się informacja o ilości przypisanych zadań (tak samo jest w przypadku aktualizacji zadania)

INSTRUKCJA

Odpalenie aplikacji:
1. Należy pobrać całą zawartość repozytorium "53556_PP_Zaliczenie" jako zip
   (przycisk "Code" > Download ZIP)
2. Wypakować do oddzielnego folderu zawartość pobranego ZIP
3. Obowiązkowo należy mieć zainstalowaną maszynę wirtualną Java (JDK 21)
4. Żeby odpalić aplikację należy otworzyć plik "53556_PP_Zaliczenie.jar" w folderze "build"

Otworzenie kodu źródłowego:
Kod źródłowy można podejrzeć w VSCode otwierając folder "src".
Ponieważ projekt był tworzony w "InteliJ Idea" przy pomocy UI buildera pliki ".form"
kod źródłowy nie posiada wszystkich elementów UI (są przechowywane w plikach o rozszerzeniu .form)
Również z tego powodu Run programu z poziomu VS code może sie nie udać.