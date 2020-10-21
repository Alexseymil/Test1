package transport;

public abstract class SportCar extends Car {

   @Override
   public CarBody carBody() {

      return CarBody.COUPE;
   }

   @Override
   public EngineType engineType() {

      return EngineType.REACTION;
   }

   }
