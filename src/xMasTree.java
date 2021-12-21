public class xMasTree {
    public static void main(String[] args) {
        /*
        1. kellenek a színek, fehér, zöld, background szinező kell. forrás: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        2. létrehozzuk a képünk alapját, a kétdimenziós tömböt
        3. megrajzoljuk az üres 9x9-es képet, azaz létrehozzuk a multidimenziós tömböt 9row és 9 column-al, fehéren.
        ilyen lesz a kép:
        FFFFFFFFF
        FFFF#FFFF
        FFF###FFF
        FF#####FF
        FFF###FFF
        FF#####FF
        F#######F
        FFFF#FFFF
        FFFFFFFFF
        4. A fa kirajzolása. If-el megadom, hogy amelyik helyre a zöld négyzetet szeretném, ott színezzen a sor és oszlop alapján
         */

        //1.
        final String ANSI_RESET = "\u001B[0m";
        final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
        final String GREEN_BACKGROUND = "\033[42m"; // GREEN
        String snow = WHITE_BACKGROUND_BRIGHT + " " + ANSI_RESET;
        String treeCanopyAndTrunk = GREEN_BACKGROUND + " " + ANSI_RESET;
        //2.
        String[][] snowBackground = new String[9][9];
        //3.
        for (int row = 0; row < snowBackground.length; row++){ //az adott sornak veszem az oszlopait
            for (int column = 0; column < snowBackground[row].length; column++) { //végigmegyek az oszlopokon
                snowBackground[row][column]= snow; //értéket adok az adott sor és oszlop által jelzett String változónak
            }
        }
        for (int row = 0; row < snowBackground.length; row++){ //szintén végigmegyek a sorokon
            for (int column = 0; column < snowBackground[row].length; column++) { //az adott sornak végigmegyek az oszlopain
                System.out.print(snowBackground[row][column]); // az előzőek mintájára kiíratom a consolra az adott értéket
            }                                            // figyelem! a print nem töri meg a sort! így egymás mellé ír!
            System.out.println(); //a println-al töröm meg a sorokat. Itt amint végigmegy a 9 oszlopon, akkor töri!
        } //így már megvan a 9x9-es fehér képünk!
        System.out.println(); // ezt csak azért hogy elválasszuk egymástól a két képet
        //4.
        String[][] tree = new String [9][9];
        tree [1][5] = treeCanopyAndTrunk;
        for (int row = 0; row < snowBackground.length; row++){ //szintén végigmegyek a sorokon
            for (int column = 0; column < snowBackground[row].length; column++) { //az adott sornak végigmegyek az oszlopain
                if (row == 1 && column == 4 ||
                        row == 2 && column == 3 || row == 2 && column == 4 || row == 2 && column == 5 ||
                        row == 3 && column == 2 || row == 3 && column == 3 || row == 3 && column == 4 || row == 3 && column == 5 || row == 3 && column == 6 ||
                        row == 4 && column == 3 || row == 4 && column == 4 || row == 4 && column == 5 ||
                        row == 5 && column == 2 || row == 5 && column == 3 || row == 5 && column == 4 || row == 5 && column == 5 || row == 5 && column == 6 ||
                        row == 6 && column == 1 || row == 6 && column == 2 || row == 6 && column == 3 || row == 6 && column == 4 || row == 6 && column == 5 || row == 6 && column == 6 || row == 6 && column == 7 ||
                        row == 7 && column == 4){
                    System.out.print(treeCanopyAndTrunk); //beszinezem zöldre a meghatározott cellákat sor és oszlop szerint
                } else {
                    System.out.print(snowBackground[row][column]); // az előzőek mintájára kiíratom a consolra az adott értéket
                }
            }                                            // figyelem! a print nem töri meg a sort! így egymás mellé ír!
            System.out.println(); //a println-al töröm meg a sorokat. Itt amint végigmegy a 9 oszlopon, akkor töri!
        } //így már megvan a teljes képünk a fenyőfával!

        /* TODO easy: kirajzolni kékkel az eget a 0-5 sorban, ahol nincs fa! Több megoldás is lehet.
                hard: leegyszerűsíteni az if feltételét, hogy ne ilyen horror legyen!
         */
    }
}
