package hashsetsimple;
public class DownTest extends Test
{
    MySet<String> set;
    public DownTest() {
        set = new MySet();
    }
    //<editor-fold desc="relleno de datos">
        private Object[] restart(){
            return new Object[]{ "Deborah","Tommy","Franco","Manuela","Miguel","Denisse" };
        }
        private Object[] elem_1(){
            return new Object[]{ "Deborah" };        
        }
        private Object[] elem_2(){
            return new Object[]{ "Deborah","Franco" };
        }
        private Object[] elem_3(){
            return new Object[]{ "Deborah","Franco","Tommy" };
        }
    //</editor-fold>
    //<editor-fold desc="pruebas">
        private void probando_borrado(Object[]arreglo, Object[]criterio) throws Exception{
            set.clear();
            for (Object obj : arreglo) {
                set.add(obj.toString());
            }
            for(Object c : criterio){
                if(c == null){
                    set.remove(null);
                    this.comprobar_que(!set.contains(null));
                } else {
                    set.remove(c.toString());
                    this.comprobar_que(!set.contains(c.toString()));
                }                        
            }
        }
        private void probando_borrado_total() throws Exception{
            set.clear();
            for (Object obj : restart()) {
                set.add(obj.toString());
            }
            java.util.ArrayList<String>c = new java.util.ArrayList();
            c.add("Deborah");
            c.add("Tommy");
            c.add("Denisse");
            this.comprobar_que(set.removeAll(c));
        }
        private void probando_retencion_total() throws Exception{
            set.clear();
            for (Object obj : restart()) {
                set.add(obj.toString());
            }
            java.util.ArrayList<String>c = new java.util.ArrayList();
            c.add("Deborah");
            c.add("Lidia");
            c.add("Agustin");
            this.comprobar_que(set.retainAll(c));
        }
    //</editor-fold>
    @Override
    void test() {
        try {
            probando_borrado(restart(), new Object[]{"Deborah","Franco","Denisse"});
            probando_borrado(restart(), new Object[]{ null });
            probando_borrado(restart(), new Object[]{"Francis","Luis"});
            probando_borrado(elem_1(), new Object[]{"Deborah"});
            probando_borrado(elem_2(), new Object[]{"Deborah"});
            probando_borrado(elem_3(), new Object[]{"Deborah"});
            probando_borrado_total();
            probando_retencion_total();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}