package controller;

public interface IcrudDao {

    public abstract boolean salvar();

    public abstract boolean deletar();

    public abstract boolean buscar();

    public abstract boolean buscarSQL();
}
