
package ConcreteVisitor;

import ConcreteComponent.Kontroler1;
import ConcreteDecorators.*;
import Visitor.Visitor;

public class VisitorPromeni implements Visitor{
    @Override
    public void visitKontroler(Kontroler1 kon1)
    {kon1.Promeni(true);}
    @Override
    public void visitKontrolerA(KonkretniDekoratorKontroleraA kdka)
    {   kdka.startAudioKlip("update.wav");
        kdka.setIkonu("update.jpg");
        kdka.prikaziOsnovnuIkonu();
     }
    @Override
    public void visitKontrolerB(KonkretniDekoratorKontroleraB kdkb)
    {  
//       if (!kdkb.proveraVrOgranicenja())
//          { kdkb.postaviPromeni(false);
//            kdkb.vratiKonOsnovni().prikaziPoruku("������ ��� Sifra predmeta ��� �����!!!");
//            kdkb.vratiKonOsnovni().getEkranskaForma().getPanel().setSifraPredmeta("0");
//          }
//       else
//            kdkb.postaviPromeni(true);
    }
}
