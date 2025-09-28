public class Cola {
    private List<Niño> niños;
    private int size;

    public Cola() {
        niños = new List<Niño>();
        size = 0;
    }

    public void addNiño(Niño niño) {
        niños.insert(niño, -1);
        size++;
    }

    public Niño removeNiño() {
        Niño saliente = niños.getFirst().getData();
        niños.remove(0);
        size--;
        return saliente;
    }

    public boolean isEmpty() {
        return niños.isEmpty();
    }

    public int size() {
        return size;
    }

    public void listaNiños() {
        Node<Niño> current = niños.getFirst();
        while (current != null) {
            System.out.print(current.getData().getNombre() + " / ");
            current = current.getNext();
        }
        System.out.println();
    }

    public boolean hayNiños() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hayNiños'");
    }

    public Object getNiños() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNiños'");
    }
}
