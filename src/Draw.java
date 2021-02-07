import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import javax.swing.*;


public class Draw extends JComponent {

    private static final long serialVersionUID = 1L;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        Rectangle2D.Double Ontario = new Rectangle2D.Double(191, 150, 30, 30);
        g2.fill(Ontario);
        g2.draw(Ontario);
        g2.drawString("Ontario", 191, 150);

        Rectangle2D.Double Quebec = new Rectangle2D.Double(255, 161, 30, 30);
        g2.fill(Quebec);
        g2.draw(Quebec);
        g2.drawString("Quebec", 255, 161);

        Rectangle2D.Double NWTerritory = new Rectangle2D.Double(146, 86, 30, 30);
        g2.fill(NWTerritory);
        g2.draw(NWTerritory);
        g2.drawString("NW Territory", 146, 86);

        Rectangle2D.Double Alberta = new Rectangle2D.Double(123, 144, 30, 30);
        g2.fill(Alberta);
        g2.draw(Alberta);
        g2.drawString("Alberta", 123, 144);

        Rectangle2D.Double Greenland = new Rectangle2D.Double(314, 61, 30, 30);
        g2.fill(Greenland);
        g2.draw(Greenland);
        g2.drawString("Greenland", 314, 61);

        Rectangle2D.Double EUnitedStates = new Rectangle2D.Double(205, 235, 30, 30);
        g2.fill(EUnitedStates);
        g2.draw(EUnitedStates);
        g2.drawString("E United States", 205, 235);

        Rectangle2D.Double WUnitedStates = new Rectangle2D.Double(135, 219, 30, 30);
        g2.fill(WUnitedStates);
        g2.draw(WUnitedStates);
        g2.drawString("W United States", 135, 219);

        Rectangle2D.Double CentralAmerica = new Rectangle2D.Double(140, 299, 30, 30);
        g2.fill(CentralAmerica);
        g2.draw(CentralAmerica);
        g2.drawString("Central America", 140, 299);

        Rectangle2D.Double Alaska = new Rectangle2D.Double(45, 89, 30, 30);
        g2.fill(Alaska);
        g2.draw(Alaska);
        g2.drawString("Alaska", 45, 89);

        g2.setColor(Color.BLACK); 
        Rectangle2D.Double GreatBritain = new Rectangle2D.Double(370, 199, 30, 30);
        g2.fill(GreatBritain);
        g2.draw(GreatBritain);
        g2.drawString("Great Britain", 370, 199);

        Rectangle2D.Double WEurope = new Rectangle2D.Double(398, 280, 30, 30);
        g2.fill(WEurope);
        g2.draw(WEurope);
        g2.drawString("W Europe", 398, 280);

        Rectangle2D.Double SEurope = new Rectangle2D.Double(465, 270, 30, 30);
        g2.fill(SEurope);
        g2.draw(SEurope);
        g2.drawString("S Europe", 465, 270);

        Rectangle2D.Double Ukraine = new Rectangle2D.Double(547, 180, 30, 30);
        g2.fill(Ukraine);
        g2.draw(Ukraine);
        g2.drawString("Ukraine", 547, 180);

        Rectangle2D.Double NEurope = new Rectangle2D.Double(460, 200, 30, 30);
        g2.fill(NEurope);
        g2.draw(NEurope);
        g2.drawString("N Europe", 460, 200);

        Rectangle2D.Double Iceland = new Rectangle2D.Double(393, 127, 30, 30);
        g2.fill(Iceland);
        g2.draw(Iceland);
        g2.drawString("Iceland", 393, 127);

        Rectangle2D.Double Scandinavia = new Rectangle2D.Double(463, 122, 30, 30);
        g2.fill(Scandinavia);
        g2.draw(Scandinavia);
        g2.drawString("Scandinavia", 463, 122);

        g2.setColor(Color.CYAN);
        Rectangle2D.Double Afghanistan = new Rectangle2D.Double(628, 227, 30, 30);
        g2.fill(Afghanistan);
        g2.draw(Afghanistan);
        g2.drawString("Afghanistan", 628, 227);

        Rectangle2D.Double India = new Rectangle2D.Double(679, 332, 30, 30);
        g2.fill(India);
        g2.draw(India);
        g2.drawString("India", 679, 332);

        Rectangle2D.Double MiddleEast = new Rectangle2D.Double(572, 338, 30, 30);
        g2.fill(MiddleEast);
        g2.draw(MiddleEast);
        g2.drawString("Middle East", 572, 338);

        Rectangle2D.Double Japan = new Rectangle2D.Double(861, 213, 30, 30);
        g2.fill(Japan);
        g2.draw(Japan);
        g2.drawString("Japan", 861, 213);

        Rectangle2D.Double Ural = new Rectangle2D.Double(645, 152, 30, 30);
        g2.fill(Ural);
        g2.draw(Ural);
        g2.drawString("Ural", 645, 152);

        Rectangle2D.Double Yakutsk = new Rectangle2D.Double(763, 70, 30, 30);
        g2.fill(Yakutsk);
        g2.draw(Yakutsk);
        g2.drawString("Yakutsk", 763, 70);

        Rectangle2D.Double Kamchatka = new Rectangle2D.Double(827, 94, 30, 30);
        g2.fill(Kamchatka);
        g2.draw(Kamchatka);
        g2.drawString("Kamchatka", 827, 94);

        Rectangle2D.Double Siam = new Rectangle2D.Double(751, 360, 30, 30);
        g2.fill(Siam);
        g2.draw(Siam);
        g2.drawString("Siam", 751, 360);

        Rectangle2D.Double Irkutsk = new Rectangle2D.Double(750, 140, 30, 30);
        g2.fill(Irkutsk);
        g2.draw(Irkutsk);
        g2.drawString("Irkutsk", 750, 140);

        Rectangle2D.Double Siberia = new Rectangle2D.Double(695, 108, 30, 30);
        g2.fill(Siberia);
        g2.draw(Siberia);
        g2.drawString("Siberia", 695, 108);

        Rectangle2D.Double Mongolia = new Rectangle2D.Double(760, 216, 30, 30);
        g2.fill(Mongolia);
        g2.draw(Mongolia);
        g2.drawString("Mongolia", 760, 216);

        Rectangle2D.Double China = new Rectangle2D.Double(735, 277, 30, 30);
        g2.fill(China);
        g2.draw(China);
        g2.drawString("China", 735, 277);

        g2.setColor(Color.ORANGE);
        Rectangle2D.Double Venezuela = new Rectangle2D.Double(213, 352, 30, 30);
        g2.fill(Venezuela);
        g2.draw(Venezuela);
        g2.drawString("Venezuela", 213, 352);

        Rectangle2D.Double Peru = new Rectangle2D.Double(221, 426, 30, 30);
        g2.fill(Peru);
        g2.draw(Peru);
        g2.drawString("Peru", 221, 426);

        Rectangle2D.Double Brazil = new Rectangle2D.Double(289, 415, 30, 30);
        g2.fill(Brazil);
        g2.draw(Brazil);
        g2.drawString("Brazil", 289, 415);

        Rectangle2D.Double Argentina = new Rectangle2D.Double(233, 523, 30, 30);
        g2.fill(Argentina);
        g2.draw(Argentina);
        g2.drawString("Argentina", 233, 523);
   
        g2.setColor(Color.RED);
        Rectangle2D.Double Congo = new Rectangle2D.Double(496, 462, 30, 30);
        g2.fill(Congo);
        g2.draw(Congo);
        g2.drawString("Congo", 496, 462);

        Rectangle2D.Double NAfrica = new Rectangle2D.Double(440, 393, 30, 30);
        g2.fill(NAfrica);
        g2.draw(NAfrica);
        g2.drawString("N Africa", 440, 393);

        Rectangle2D.Double SAfrica = new Rectangle2D.Double(510, 532, 30, 30);
        g2.fill(SAfrica);
        g2.draw(SAfrica);
        g2.drawString("S Africa", 510, 532);

        Rectangle2D.Double Egypt = new Rectangle2D.Double(499, 354, 30, 30);
        g2.fill(Egypt);
        g2.draw(Egypt);
        g2.drawString("Egypt", 499, 354);

        Rectangle2D.Double EAfrica = new Rectangle2D.Double(547, 432, 30, 30);
        g2.fill(EAfrica);
        g2.draw(EAfrica);
        g2.drawString("E Africa", 547, 432);

        Rectangle2D.Double Madagascar = new Rectangle2D.Double(586, 545, 30, 30);
        g2.fill(Madagascar);
        g2.draw(Madagascar);
        g2.drawString("Madagascar", 586, 545);

        g2.setColor(Color.GREEN);
        Rectangle2D.Double EAustralia = new Rectangle2D.Double(889, 537, 30, 30);
        g2.fill(EAustralia);
        g2.draw(EAustralia);
        g2.drawString("E Australia", 889, 537);

        Rectangle2D.Double NGuinea = new Rectangle2D.Double(850, 429, 30, 30);
        g2.fill(NGuinea);
        g2.draw(NGuinea);
        g2.drawString("New Guinea", 850, 429);

        Rectangle2D.Double WAustraila = new Rectangle2D.Double(813, 526, 30, 30);
        g2.fill(WAustraila);
        g2.draw(WAustraila);
        g2.drawString("W Austraila", 813, 526);

        Rectangle2D.Double Indonesia = new Rectangle2D.Double(771, 454, 30, 30);
        g2.fill(Indonesia);
        g2.draw(Indonesia);
        g2.drawString("Indonesia", 771, 454);

     
        g2.setColor(Color.BLACK);
        Line2D.Double line1 = new Line2D.Double(191, 150, 255, 161);
        Line2D.Double line2 = new Line2D.Double(191, 150, 146, 86);
        Line2D.Double line3 = new Line2D.Double(191, 150, 123, 144);
        Line2D.Double line4 = new Line2D.Double(191, 150, 314, 61);
        Line2D.Double line5 = new Line2D.Double(191, 150, 205, 235);
        Line2D.Double line6 = new Line2D.Double(191, 150, 135, 219);
        Line2D.Double line7 = new Line2D.Double(45, 89, 146, 86);
        Line2D.Double line8 = new Line2D.Double(45, 89, 123, 144);
        Line2D.Double line9 = new Line2D.Double(123, 144, 146, 86);
        Line2D.Double line10 = new Line2D.Double(123, 144, 135, 219);
        Line2D.Double line11 = new Line2D.Double(135, 219, 205, 235);
        Line2D.Double line12 = new Line2D.Double(135, 219, 140, 299);
        Line2D.Double line13 = new Line2D.Double(140, 299, 205, 235);
        Line2D.Double line14 = new Line2D.Double(205, 235, 255, 161);
        Line2D.Double line15 = new Line2D.Double(255, 161, 314, 61);
        Line2D.Double line16 = new Line2D.Double(146, 86, 314, 61);
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
        g2.draw(line4);
        g2.draw(line5);
        g2.draw(line6);
        g2.draw(line7);
        g2.draw(line8);
        g2.draw(line9);
        g2.draw(line10);
        g2.draw(line11);
        g2.draw(line12);
        g2.draw(line13);
        g2.draw(line14);
        g2.draw(line15);
        g2.draw(line16);
        Line2D.Double line17 = new Line2D.Double(314, 61, 393, 127);
        Line2D.Double line18= new Line2D.Double(393, 127, 463, 122);
        Line2D.Double line19 = new Line2D.Double(393, 127, 370, 199);
        Line2D.Double line20 = new Line2D.Double(463, 122, 370, 199);
        Line2D.Double line21 = new Line2D.Double(460, 200, 463, 122);
        Line2D.Double line22 = new Line2D.Double(460, 200, 370, 199);
        Line2D.Double line23 = new Line2D.Double(460, 200, 547, 180);
        Line2D.Double line24 = new Line2D.Double(460, 200, 398, 280);
        Line2D.Double line25 = new Line2D.Double(460, 200, 465, 270);
        Line2D.Double line26 = new Line2D.Double(370, 199, 398, 280);
        Line2D.Double line27 = new Line2D.Double(398, 280, 465, 270);
        Line2D.Double line28 = new Line2D.Double(465, 270, 547, 180);
        Line2D.Double line29 = new Line2D.Double(547, 180, 463, 122);
        Line2D.Double line30 = new Line2D.Double(547, 180, 572, 338);
        Line2D.Double line31 = new Line2D.Double(465, 270, 572, 338);
        Line2D.Double line32 = new Line2D.Double(547, 180, 645, 152);
        Line2D.Double line33 = new Line2D.Double(547, 180, 628, 227);
        g2.draw(line17);
        g2.draw(line18);
        g2.draw(line19);
        g2.draw(line20);
        g2.draw(line21);
        g2.draw(line22);
        g2.draw(line23);
        g2.draw(line24);
        g2.draw(line25);
        g2.draw(line26);
        g2.draw(line27);
        g2.draw(line28);
        g2.draw(line29);
        g2.draw(line30);
        g2.draw(line31);
        g2.draw(line32);
        g2.draw(line33);
        Line2D.Double line34 = new Line2D.Double(735, 277, 645, 152);
        Line2D.Double line35 = new Line2D.Double(735, 277, 628, 227);
        Line2D.Double line36 = new Line2D.Double(735, 277, 695, 108);
        Line2D.Double line37 = new Line2D.Double(735, 277, 760, 216);
        Line2D.Double line38 = new Line2D.Double(735, 277, 751, 360);
        Line2D.Double line39 = new Line2D.Double(735, 277, 679, 332);
        Line2D.Double line40 = new Line2D.Double(679, 332, 628, 227);
        Line2D.Double line41 = new Line2D.Double(679, 332, 572, 338);
        Line2D.Double line42 = new Line2D.Double(679, 332, 751, 360);
        Line2D.Double line43 = new Line2D.Double(628, 227, 572, 338);
        Line2D.Double line44 = new Line2D.Double(628, 227, 645, 152);
        Line2D.Double line45 = new Line2D.Double(750, 140, 763, 70);
        Line2D.Double line46= new Line2D.Double(750, 140, 827, 94);
        Line2D.Double line47 = new Line2D.Double(750, 140, 695, 108);
        Line2D.Double line48 = new Line2D.Double(750, 140, 760, 216);
        Line2D.Double line49 = new Line2D.Double(695, 108, 645, 152);
        Line2D.Double line50 = new Line2D.Double(695, 108, 763, 70);
        Line2D.Double line51 = new Line2D.Double(827, 94, 861, 213);
        Line2D.Double line52 = new Line2D.Double(827, 94, 763, 70);
        Line2D.Double line53 = new Line2D.Double(827, 94, 760, 216);
        Line2D.Double line54 = new Line2D.Double(760, 216, 861, 213);
        Line2D.Double line55 = new Line2D.Double(760, 216, 695, 108);
        g2.draw(line34);
        g2.draw(line35);
        g2.draw(line36);
        g2.draw(line37);
        g2.draw(line38);
        g2.draw(line39);
        g2.draw(line40);
        g2.draw(line41);
        g2.draw(line42);
        g2.draw(line43);
        g2.draw(line44);
        g2.draw(line45);
        g2.draw(line46);
        g2.draw(line47);
        g2.draw(line48);
        g2.draw(line49);
        g2.draw(line50);
        g2.draw(line51);
        g2.draw(line52);
        g2.draw(line53);
        g2.draw(line54);
        g2.draw(line55);
        Line2D.Double line56 = new Line2D.Double(140, 299, 213, 352);
        Line2D.Double line57 = new Line2D.Double(213, 352, 221, 426);
        Line2D.Double line58 = new Line2D.Double(213, 352, 289, 415);
        Line2D.Double line59 = new Line2D.Double(289, 415, 221, 426);
        Line2D.Double line60 = new Line2D.Double(289, 415, 440, 393);
        Line2D.Double line61 = new Line2D.Double(289, 415, 233, 523);
        Line2D.Double line62 = new Line2D.Double(233, 523, 221, 426);
        g2.draw(line56);
        g2.draw(line57);
        g2.draw(line58);
        g2.draw(line59);
        g2.draw(line60);
        g2.draw(line61);
        g2.draw(line62);
        Line2D.Double line63 = new Line2D.Double(547, 432, 572, 338);
        Line2D.Double line64 = new Line2D.Double(547, 432, 496, 462);
        Line2D.Double line65 = new Line2D.Double(547, 432, 440, 393);
        Line2D.Double line66 = new Line2D.Double(547, 432, 510, 532);
        Line2D.Double line67 = new Line2D.Double(547, 432, 499, 354);
        Line2D.Double line68 = new Line2D.Double(547, 432, 586, 545);
        Line2D.Double line69 = new Line2D.Double(510, 532, 496, 462);
        Line2D.Double line70 = new Line2D.Double(510, 532, 586, 545);
        Line2D.Double line71 = new Line2D.Double(440, 393, 496, 462);
        Line2D.Double line72 = new Line2D.Double(440, 393, 440, 393);
        Line2D.Double line73 = new Line2D.Double(572, 338, 499, 354);
        Line2D.Double line74 = new Line2D.Double(499, 354, 440, 393);
        g2.draw(line63);
        g2.draw(line64);
        g2.draw(line65);
        g2.draw(line66);
        g2.draw(line67);
        g2.draw(line68);
        g2.draw(line69);
        g2.draw(line70);
        g2.draw(line71);
        g2.draw(line72);
        g2.draw(line73);
        g2.draw(line74);
        Line2D.Double line75 = new Line2D.Double(751, 360, 771, 454);
        Line2D.Double line76 = new Line2D.Double(771, 454, 850, 429);
        Line2D.Double line77 = new Line2D.Double(771, 454, 813, 526);
        Line2D.Double line78 = new Line2D.Double(813, 526, 850, 429);
        Line2D.Double line79 = new Line2D.Double(889, 537, 813, 526);
        Line2D.Double line80 = new Line2D.Double(889, 537, 850, 429);
        g2.draw(line75);
        g2.draw(line76);
        g2.draw(line77);
        g2.draw(line78);
        g2.draw(line79);
        g2.draw(line80);
        g2.setColor(Color.BLACK);
        g2.drawString("(North America(Continent)", 150, 50);
        g2.setColor(Color.BLACK);
        g2.drawString("(South America(Continent))", 10, 450);
        g2.setColor(Color.BLACK);
        g2.drawString("(Africa(Continent))", 600, 450);
        g2.setColor(Color.BLACK);
        g2.drawString("(Europe(Continent))", 450, 80);
        g2.setColor(Color.BLACK);
        g2.drawString("(Asia(Continent))", 900, 100);
        g2.setColor(Color.BLACK);
        g2.drawString("(Australia(Continent))", 900, 450);
             
    }
    public void DrawArmy(Graphics g){
    	Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.drawString("1", 191+12, 150+20);
        g2.drawString("1", 255+12, 161+20);
        g2.drawString("1", 146+12, 86+20);
        g2.drawString("1", 123+12, 144+20);
        g2.drawString("1", 314+12, 61+20);
        g2.drawString("1", 205+12, 235+20);
        g2.drawString("1", 135+12, 219+20);
        g2.drawString("1", 140+12, 299+20);
        g2.drawString("1", 45+12, 89+20);
        g2.drawString("1", 370+12, 199+20);
        g2.drawString("1", 398+12, 280+20);
        g2.drawString("1", 465+12, 270+20);
        g2.drawString("1", 547+12, 180+20);
        g2.drawString("1", 460+12, 200+20);
        g2.drawString("1", 393+12, 127+20);
        g2.drawString("1", 463+12, 122+20);
        g2.drawString("1", 628+12, 227+20);
        g2.drawString("1", 679+12, 332+20);
        g2.drawString("1", 572+12, 338+20);
        g2.drawString("1", 861+12, 213+20);
        g2.drawString("1", 645+12, 152+20);
        g2.drawString("1", 763+12, 70+20);
        g2.drawString("1", 827+12, 94+20);
        g2.drawString("1", 751+12, 360+20);
        g2.drawString("1", 750+12, 140+20);
        g2.drawString("1", 695+12, 108+20);
        g2.drawString("1", 760+12, 216+20);
        g2.drawString("1", 735+12, 277+20);
        g2.drawString("1", 213+12, 352+20);
        g2.drawString("1", 221+12, 426+20);
        g2.drawString("1", 289+12, 415+20);
        g2.drawString("1", 233+12, 523+20);
        g2.drawString("1", 496+12, 462+20);
        g2.drawString("1", 440+12, 393+20);
        g2.drawString("1", 510+12, 532+20);
        g2.drawString("1", 499+12, 354+20);
        g2.drawString("1", 547+12, 432+20);
        g2.drawString("1", 586+12, 545+20);
        g2.drawString("1", 889+12, 537+20);
        g2.drawString("1", 850+12, 429+20);
        g2.drawString("1", 813+12, 526+20);
        g2.drawString("1", 771+12, 454+20);
    }
}
