package MercadoUtils;

import java.util.Date;

public class RelatVendas {

	private int codigoVenda;
	private int codigoProduto;
	private String cpfCliente;
	private String cpfVendedor;
	private Date data;
	
	
//	Date x=new Date(); 
//	System.out.println(x); 
//	java.text.SimpleTextFormat()
	
	public RelatVendas() {
		
	}
	public RelatVendas(int codigoVenda, int codigoProduto, String cpfCliente, String cpfVendedor, Date data) {
		super();
		this.codigoVenda = codigoVenda;
		this.codigoProduto = codigoProduto;
		this.cpfCliente = cpfCliente;
		this.cpfVendedor = cpfVendedor;
		this.data = data;
	}
	public int getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getCpfVendedor() {
		return cpfVendedor;
	}
	public void setCpfVendedor(String cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
	}
	public Date getData() {
		return data;
	}
	public void setData() {
		Date x = new Date(); 
		this.data = x;
	}
	
	
}