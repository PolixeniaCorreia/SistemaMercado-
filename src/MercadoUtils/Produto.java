package MercadoUtils;

public class Produto {
	
	private int codigoProduto;
	private String nome;
	private String descri�ao;
	private int quantidade;
	
	public Produto() {
	
	}
	
	public Produto(int codigoProduto, String nome, String descri�ao, int quantidade) {
		super();
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.descri�ao = descri�ao;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescri�ao() {
		return descri�ao;
	}
	public void setDescri�ao(String descri�ao) {
		this.descri�ao = descri�ao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

}
