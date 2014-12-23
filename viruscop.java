class viruscop
{
	String serialnumber;
	String virusname;
	String virussignature;
	public int getslno()
	{
		int x=Integer.parseInt(this.serialnumber);
		return x;
	}
	public void setslno(String serialnumber)
	{
		this.serialnumber=serialnumber;
	
	}
	public String getvn()
	{
		return this.virusname;
	}
	public void setvn(String virusname)
	{
		this.virusname=virusname;
	
	}
	public String getvs()
	{
		return this.virussignature;
	}
	public void setvs(String virussignature)
	{
		this.virussignature=virussignature;
	
	}
}