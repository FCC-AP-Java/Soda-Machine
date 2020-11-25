import java.util.Scanner;
import java.lang.Math;

public class SodaMachine
{
  private double totalMoney;
  private double fedMoney;
  private int cokeCans;
  private int spriteCans;
  private int fantaCans;

  Scanner input = new Scanner(System.in);

  public SodaMachine()
  {
    totalMoney = 3.00;
    fedMoney = 0.00;
    cokeCans = 5;
    spriteCans = 3;
    fantaCans = 2;
  }

  public SodaMachine(double t, int c, int s, int f)
  {
    totalMoney = t;
    fedMoney = 0.00;
    cokeCans = c;
    spriteCans = s;
    fantaCans = f;
  }

  public double userMoneyInput()
  {
    System.out.println("Please enter the number of quarters.");
    double quarters = 0.25 * input.nextDouble();
    System.out.println("Please enter the number of dimes.");
    double dimes = 0.10 * input.nextDouble();
    System.out.println("Please enter the number of nickels.");
    double nickels = 0.05 * input.nextDouble();
    return quarters + dimes + nickels;
  }

  public void userChoice()
  {
    System.out.println("Coke: $0.80 | Sprite: $1.15 | Fanta: $1.00");
    fedMoney = userMoneyInput();
    System.out.println("Coke: 1 | Sprite: 2 | Fanta: 3");
    int userChoice = input.nextInt();

    if (userChoice == 1)
    {
      if (cokeCans == 0)
      {
        System.out.println("This machine is out of Coke cans. Please try again.");
        userChoice();
      }
      else
      {
        if (fedMoney < 0.80)
        {
          System.out.println("You do not have enough money. Please try again.");
          userChoice();
        }
        else
        {
          if ((fedMoney - 0.80) > totalMoney)
          {
            System.out.println("There is not enough change in the machine. Please try again.");
            userChoice();
          }
          else
          {
            System.out.println("Thank you for purchasing a can of Coke.");
            System.out.println("Your change is $" + (double)Math.round((fedMoney - 0.80)*100000d) / 100000d);
            totalMoney -= (fedMoney - 0.80);
            cokeCans--;
          }
          
        }
      }
    }

    else if (userChoice == 2)
    {
      if (spriteCans == 0)
      {
        System.out.println("This machine is out of Sprite cans. Please try again.");
        userChoice();
      }
      else
      {
        if (fedMoney < 1.15)
        {
          System.out.println("You do not have enough money. Please try again.");
          userChoice();
        }
        else
        {
          if ((fedMoney - 1.15) > totalMoney)
          {
            System.out.println("There is not enough change in the machine. Please try again.");
            userChoice();
          }
          else
          {
            System.out.println("Thank you for purchasing a can of Sprite.");
            System.out.println("Your change is $" + (double)Math.round((fedMoney - 1.15)*100000d) / 100000d);
            totalMoney -= (fedMoney - 1.15);
            spriteCans--;
          }
        }
      }
    }

    else if (userChoice == 3)
    {
      if (fantaCans == 0)
      {
        System.out.println("This machine is out of Fanta cans. Please try again.");
        userChoice();
      }
      else
      {
        if (fedMoney < 1.00)
        {
          System.out.println("You do not have enough money. Please try again.");
          userChoice();
        }
        else
        {
          if ((fedMoney - 1.00) > totalMoney)
          {
            System.out.println("There is not enough change in the machine. Please try again.");
            userChoice();
          }
          else
          {
            System.out.println("Thank you for purchasing a can of Fanta.");
            System.out.println("Your change is $" + (double)Math.round((fedMoney - 1.00)*100000d) / 100000d);
            totalMoney -= (fedMoney - 1.00);
            fantaCans--;
          }
        }
      }
    }

    else
    {
      System.out.println("You have selected an invalid option. Please try again.");
      userChoice();
    }
  }

  public void beginPurchases()
  {
    int continueLoop = 1;
    while (continueLoop == 1)
    {
      if (totalMoney < 2.00)
      {
        System.out.println("You must enter exact change.");
      }
      userChoice();
      System.out.println("Please enter 1 if you would like to continue purchasing.");
      continueLoop = input.nextInt();
    }
  }
}