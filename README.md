# 1.11.2.Object_serialization
# Objektu serializācija

Programma `Main.java` attēlo izvēlni ar komandām Create, Calculate, View, About un Exit un nolasa lietotāja izvēlēto komandas numuru.<br>
<br>
Izvēloties `Create`, tiek izveidots fails `Students.dat` (tekošajā mapē) un tajā tiek saglabāti pieci klases `Student` objekti, izmantojot objektu serializāciju. Izvēloties `View`, programma nolasa `Students.dat` un izvada ekrānā tajā esošo studentu informāciju. <br>
Izvēloties `Exit`, programmas darbs tiek pabeigts, bet komandas `Calculate` un `About` sākotnēji izsauc atbilstošās metodes, kas sagatavē neko nedara.<br>
<br>
Uzdevuma ietvaros metode `calculate` jāpapildina tā, lai tā ievadītu studenta numuru (studenti numurēti sākot ar 1) un failā `Students.dat` atrastajam studentam aizvietotu atzīmes ar jaunām, kuras tiek ievadītas no tastatūras. Ja ievadītais studenta numurs ir negatīvs vai lielāks par studentu skaitu failā, jāizvada paziņojums: `no such student`.<br>
Metode `about` jāmodificē tā, lai tā izvadītu programmas izstrādātāja datus: studenta apliecības numuru, vārdu, uzvārdu un grupu.
