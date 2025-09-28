class Monitor {
    private String nombre;
    private Cola colaNinos;
    private boolean estaJugando;
    private Node<Nino> ninoTurno;

    public Monitor(String nombre) {
        this.nombre = nombre;
        this.colaNinos = new Cola();
        estaJugando = false;
    }

    public void recibeNino(Nino nino) {
        colaNinos.addNino(nino);
    }

    private void recibeNino(Nino nino, Pizarra pizarrin) {
        nino.recibirPizarrin(pizarrin);
        colaNinos.addNino(nino);
    }

    public boolean tieneNinos() {
        return colaNinos.hayNinos();
    }

    public boolean puedeJugar() {
        return colaNinos.size() >= 5;
    }

    public boolean estaJugando() {
        return estaJugando;
    }

    public void mostrarListaNinos() {
        System.out.print("> " + this.nombre + " --> ");
        colaNinos.listaNinos();
        System.out.println();
    }

    public void entregaNinos(Monitor otroMonitor) {
        while (colaNinos.hayNinos()) {
            System.out.println(" >  " + this.nombre + " ENTREGA NINO");
            Nino unNino = colaNinos.removeNino();
            otroMonitor.recibeNino(unNino, new Pizarra());
        }
    }

    public void jugar() {
        if (!estaJugando) {
            estaJugando = true;
            limpiarPizarrines();
            ninoTurno = colaNinos.getNinos().getFirst();
            ninoTurno.getData().recibirMensaje("ABCDEFGHIJKLM");
        } else {
            Node<Nino> nino = colaNinos.getNinos().getFirst();
            while (nino != ninoTurno) {
                nino = nino.getNext();
            }

            if (nino.getNext() == null) {
                estaJugando = false;
                ninoTurno = colaNinos.getNinos().getFirst();
            } else {
                Nino ninoActual = nino.getData();
                Nino siguienteNino = nino.getNext().getData();
                siguienteNino.recibirMensaje(ninoActual.mostrarMensaje());
                ninoTurno = nino.getNext();
            }
        }
    }

    private void limpiarPizarrines() {
        Node<Nino> nino = colaNinos.getNinos().getFirst();
        while (nino != null) {
            nino.getData().limpiarPizarrin();
            nino = nino.getNext();
        }
    }
}
