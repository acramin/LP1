public class Ponto
{
   private double coordenadaX, coordenadaY;

   public Ponto()
   {
      coordenadaX = 0.0;
      coordenadaY = 0.0;
   }

   public Ponto(double x, double y)
   {
      coordenadaX = x;
      coordenadaY = y;
   }

   public double getCoordenadaX() {
      return coordenadaX;
   }

   public double getCoordenadaY() {
      return coordenadaY;
   }

   public void setCoordenadaX(double coordenadaX) {
      this.coordenadaX = coordenadaX;
   }

   public void setCoordenadaY(double coordenadaY) {
      this.coordenadaY = coordenadaY;
   }

   public String toString()
   {
      return "Ponto: [coordenadaX =" + coordenadaX + 
      "][coordenadaY =" + coordenadaY +"]";
   }

}