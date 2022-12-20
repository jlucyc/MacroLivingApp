package com.mlc.MLC.components;

import com.mlc.MLC.models.Ingredient;
import com.mlc.MLC.models.Recipe;
import com.mlc.MLC.models.Steps;
import com.mlc.MLC.models.User;
import com.mlc.MLC.repository.IngredientRepository;
import com.mlc.MLC.repository.RecipeRepository;
import com.mlc.MLC.repository.StepsRepository;
import com.mlc.MLC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    StepsRepository stepsRepository;


    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User(0,0,0,0,0);
        userRepository.save(user1);

        // BACsalad data (NOT FINAL)
        Ingredient bacon = new Ingredient("Bacon",5, 0,7,0,false,false, "2 slices of", 80.0);
        ingredientRepository.save(bacon);
        Ingredient apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true , "1", 75.0);
        ingredientRepository.save(apple);
        Ingredient cashews = new Ingredient("Cashews", 3.3, 6, 8.7, 0.7, true, true, "20g", 113.0);
        ingredientRepository.save(cashews);

        Steps bacSaladSteps = new Steps("");
        stepsRepository.save(bacSaladSteps);
        bacSaladSteps.setStep1("Chop apple");
        bacSaladSteps.setStep2("Cook and chop bacon");
        bacSaladSteps.setStep3("Weigh out cashews");
        bacSaladSteps.setStep4("Add all ingredients to bowl");
        bacSaladSteps.setStep5("Tell yourself its healthy because it has salad in the name ");
        stepsRepository.save(bacSaladSteps);


        Recipe bacSalad = new Recipe("BAC Salad", bacSaladSteps, "https://www.recipegirl.com/wp-content/uploads/2007/11/Apple-Bacon-Salad-Recipe.jpg");
        recipeRepository.save(bacSalad);

        bacSalad.addIngredient(bacon);
        bacSalad.addIngredient(apple);
        bacSalad.addIngredient(cashews);
        recipeRepository.save(bacSalad);

        //Portobello Mushroom And Squash Risotto data(NOT FINAL)
        Ingredient onion = new Ingredient("Onion", 0.5, 4, 0, 1, true, true, "1/2 medium", 22.0);
        ingredientRepository.save(onion);
        Ingredient oliveOil = new Ingredient("Olive Oil", 0,0,7,0, true, true, "1/2 tbs", 60.0);
        ingredientRepository.save(oliveOil);
        Ingredient squash = new Ingredient("Squash",3,18,0.3,1.4, true, true, "1/2 medium",71.0);
        ingredientRepository.save(squash);
        Ingredient risottoRice = new Ingredient("Risotto Rice",5.5,58.5,0.5,0,true,true,"75g",262.0);
        ingredientRepository.save(risottoRice);
        Ingredient whiteWine = new Ingredient("White Wine",0,0.8,0,0, true,true,"30ml",25.0);
        ingredientRepository.save(whiteWine);
        Ingredient vegetableStockCube = new Ingredient("Vegetable Stock",0.3, 1.5,1,0.2,true,true,"1 cube",15.0);
        ingredientRepository.save(vegetableStockCube);
        Ingredient parmesanCheese = new Ingredient("ParmesanCheese", 7.2, .75, 5.5, 0, false, false, "20g",81.0);
        ingredientRepository.save(parmesanCheese);
        Ingredient portobelloMushroom = new Ingredient("Portobello Mushroom",1,2,0.2,0.7,true,true, "large", 11.0);
        ingredientRepository.save(portobelloMushroom);

        Steps portobelloMushroomAndSquashRisottoSteps = new Steps("Prepare Mushrooms");
        stepsRepository.save(portobelloMushroomAndSquashRisottoSteps);
        portobelloMushroomAndSquashRisottoSteps.setStep2("In a large pot add two teaspoons of olive oil");
        portobelloMushroomAndSquashRisottoSteps.setStep3("Add the onions to the pot");
        portobelloMushroomAndSquashRisottoSteps.setStep4("Fry onions till they soften, while they soften half the squash and place in a steamer. Cover and steam for 10 min");
        portobelloMushroomAndSquashRisottoSteps.setStep5("When the squash is tender, remove and let cool. Once colled scoop out flesh with a spoon and mash");
        portobelloMushroomAndSquashRisottoSteps.setStep6("To the onions add the barley, white wine and thyme and stir then add the stock and raise the heat to high. Once boiling reduce the heat, cover and let cook for 30 mins. Then stir in teh squash and simmer until think and creamy");
        portobelloMushroomAndSquashRisottoSteps.setStep7("Stir in lemon and parmesan and remove from the heat");
        portobelloMushroomAndSquashRisottoSteps.setStep8("Heat a large pan with a drizzle of olive oil, place in teh mushroom slices and cook for 3-4 min or until browned");
        portobelloMushroomAndSquashRisottoSteps.setStep9("Serve risotto with mushrooms arranged on top");
        stepsRepository.save(portobelloMushroomAndSquashRisottoSteps);

        Recipe portobelloMushroomAndSquashRisotto = new Recipe("Portobello Mushroom And Squash Risotto", portobelloMushroomAndSquashRisottoSteps, "https://blog.myfitnesspal.com/wp-content/uploads/2018/08/Seared-Portobello-Mushroom-and-Squash-Barley-Risotto.jpg");
        recipeRepository.save(portobelloMushroomAndSquashRisotto);
        portobelloMushroomAndSquashRisotto.addIngredient(onion);
        portobelloMushroomAndSquashRisotto.addIngredient(oliveOil);
        portobelloMushroomAndSquashRisotto.addIngredient(squash);
        portobelloMushroomAndSquashRisotto.addIngredient(risottoRice);
        portobelloMushroomAndSquashRisotto.addIngredient(whiteWine);
        portobelloMushroomAndSquashRisotto.addIngredient(vegetableStockCube);
        portobelloMushroomAndSquashRisotto.addIngredient(parmesanCheese);
        portobelloMushroomAndSquashRisotto.addIngredient(portobelloMushroom);
        recipeRepository.save(portobelloMushroomAndSquashRisotto);


        //Vegan Chickpea Frittata

        Ingredient cauliflower = new Ingredient("Cauliflower", 2, 5, 0, 2, true, true, "100g", 25.00);
        ingredientRepository.save(cauliflower);
        Ingredient spinach = new Ingredient("Spinach", 1.6, 2.4, 0.4, 1.2, true, true, "60g", 14.0);
        ingredientRepository.save(spinach);
        Ingredient chickpeaFlour = new Ingredient("Chickpea Flour", 16, 36.1, 3.5, 5.5, true, true, "70g", 250.0);
        ingredientRepository.save(chickpeaFlour);

        Steps veganChickpeaFrittataSteps = new Steps("Preheat oven to 190oC and use 1 tsp of olive oil to grease a round baking tin");
        stepsRepository.save(veganChickpeaFrittataSteps);
        veganChickpeaFrittataSteps.setStep2("Place a large saute pan over medium-high heat, coat with remaining olive oil and add the diced onion and chopped cauliflower.");
        veganChickpeaFrittataSteps.setStep3("Stir, reducing the heat to medium when it starts to sizzle. When the cauliflower is tender, about 4 minutes, remove from the heat and stir in the spinach and salt. Let it stand as the spinach wilts.");
        veganChickpeaFrittataSteps.setStep4("In a medium bowl, whisk the chickpea flour, pepper and 1 1/2 cups (375ml) water. Stir the cooked vegetables into the chickpea mixture, then pour into the prepared pie pan. Smooth the top.");
        veganChickpeaFrittataSteps.setStep5("Bake for 45 minutes, until the top is cracked and feels firm when pressed. Let cool for 5 minutes on a rack before slicing in 6 pieces.");
        stepsRepository.save(veganChickpeaFrittataSteps);

        Recipe veganChickpeaFrittata = new Recipe("Vegan Chickpea Frittata", veganChickpeaFrittataSteps, "https://blog.myfitnesspal.com/wp-content/uploads/2019/11/Vegan-Chickpea-Frittata-752x472.jpg");
        recipeRepository.save(veganChickpeaFrittata);
        veganChickpeaFrittata.addIngredient(oliveOil);
        veganChickpeaFrittata.addIngredient(onion);
        veganChickpeaFrittata.addIngredient(cauliflower);
        veganChickpeaFrittata.addIngredient(spinach);
        veganChickpeaFrittata.addIngredient(chickpeaFlour);
        recipeRepository.save(veganChickpeaFrittata);

        //Mushroom and Kale Pasta

        Ingredient garlic = new Ingredient("Garlic", 0.1, 1, 0, 0, true, true, "1 clove", 4.0);
        ingredientRepository.save(garlic);
        Ingredient penne = new Ingredient("Penne", 6, 37, 1, 1.75, false, true, "50g", 176.0);
        ingredientRepository.save(penne);
        Ingredient kale = new Ingredient("Kale", 2.3, 4.6, 0, 2.3, true, true, "50g", 23.0);
        ingredientRepository.save(kale);
        Ingredient boursin = new Ingredient("Boursin Cheese", 1.7, 0.8, 10.3, 0, false, true, "25g", 53.0);
        ingredientRepository.save(boursin);

        Steps mushroomAndKalePastaSteps = new Steps("Put the oil in the pot,When the oil is hot, add the mushrooms, onions and salt, and cook, stirring frequently, until mushrooms begin to release their juices, 5 minutes.");
        stepsRepository.save(mushroomAndKalePastaSteps);
        mushroomAndKalePastaSteps.setStep2("Add the garlic and cook until fragrant, 30 seconds.");
        mushroomAndKalePastaSteps.setStep3("Add the pasta to a pot of boiling salted water and cook for 10-12 minutes");
        mushroomAndKalePastaSteps.setStep4("Drain the pasta but keep 1/4 cup of the water. Add the water and kale to the mushroom pan and let it soften for a few minutes");
        mushroomAndKalePastaSteps.setStep5("Take the pan off the heat an stir in the cheese till combined. add the sauce to your pasta and enjoy!");
        stepsRepository.save(mushroomAndKalePastaSteps);

        Recipe mushroomAndKalePasta = new Recipe("Mushroom and Kale Pasta", mushroomAndKalePastaSteps, "https://skinnyspatula.com/wp-content/uploads/2020/12/Mushroom_Parmesan_Kale_Pasta4-792x1024.jpg.webp");
        recipeRepository.save(mushroomAndKalePasta);
        mushroomAndKalePasta.addIngredient(oliveOil);
        mushroomAndKalePasta.addIngredient(portobelloMushroom);
        mushroomAndKalePasta.addIngredient(onion);
        mushroomAndKalePasta.addIngredient(garlic);
        mushroomAndKalePasta.addIngredient(penne);
        mushroomAndKalePasta.addIngredient(kale);
        mushroomAndKalePasta.addIngredient(boursin);
        recipeRepository.save(mushroomAndKalePasta);

        // Banana PB oats

        Ingredient oats = new Ingredient("Oats", 6, 29.5, 3.9,4.5, true, true, "45g", 186.0);
        ingredientRepository.save(oats);
        Ingredient peanutButter = new Ingredient("Peanut Butter", 3, 0.8, 6, 0.7, true, true, "15g", 71.0);
        ingredientRepository.save(peanutButter);
        Ingredient banana = new Ingredient("Banana", 1, 21.6, 0.3, 2.5, true, true, "1", 84.0);
        ingredientRepository.save(banana);

        Steps bananaPbOatsSteps = new Steps("Put oats and 135ml water in a pan and heat gradually");
        stepsRepository.save(bananaPbOatsSteps);
        bananaPbOatsSteps.setStep2("stir occasionally while oats thicken");
        bananaPbOatsSteps.setStep3("Once its bubbling - remove from the heat and por into a bowl");
        bananaPbOatsSteps.setStep4("Add a tbs of peanut butter and chopped banana");
        stepsRepository.save(bananaPbOatsSteps);

        Recipe bananaPbOats = new Recipe("Banana and Peanut Butter Oats", bananaPbOatsSteps, "https://www.spoonfulofflavor.com/wp-content/uploads/2021/10/peanut-butter-banana-oatmeal-recipe.jpg");
        recipeRepository.save(bananaPbOats);
        bananaPbOats.addIngredient(oats);
        bananaPbOats.addIngredient(banana);
        bananaPbOats.addIngredient(peanutButter);
        recipeRepository.save(bananaPbOats);

        //Peanut Butter Breakfast Cookies

        Ingredient egg = new Ingredient("Egg", 6.3, 0.4, 4.8, 0, false, true, "1", 72.0);
        ingredientRepository.save(egg);
        Ingredient honey = new Ingredient("Honey", 0.1, 17.3, 0, 0, false, true, "1 tbs", 64.0);
        ingredientRepository.save(honey);
        Ingredient cinnamon = new Ingredient("Cinnamon", 0, 0, 0, 0, true, true, "1tsp", 0.0);
        ingredientRepository.save(cinnamon);

        Steps pbBreakfastCookiesSteps = new Steps("Preheat the oven to 350°F. Spray a cookie sheet with cooking spray.");
        stepsRepository.save(pbBreakfastCookiesSteps);
        pbBreakfastCookiesSteps.setStep2("Add the ripe bananas and eggs into a medium mixing bowl. Mix with a spatula, mashing on the banana to get chunks as small as possible.");
        pbBreakfastCookiesSteps.setStep3("Add the oats, peanut butter, honey, and salt, and stir until just combined. The mixture will get thick and hard to stir.");
        pbBreakfastCookiesSteps.setStep4("Use a 1/4 cup measure to portion cookie dough into 12 balls. Take each ball and split it in half to create 24 smaller balls. Roll each ball and lightly smash it between your palms to create a mini cookie.");
        pbBreakfastCookiesSteps.setStep5("Place the cookies on the baking sheet. Bake until the edges start to brown, 12 to 15 minutes.");
        stepsRepository.save(pbBreakfastCookiesSteps);

        Recipe pbBreakfastCookies = new Recipe("Peanut Butter Breakfast Cookies", pbBreakfastCookiesSteps, "https://marisamoore.com/wp-content/uploads/2016/07/Breakfast-Cookies-3-Ingredient-Peanut-Butter-Oatmeal-Cookies.jpg");
        recipeRepository.save(pbBreakfastCookies);
        pbBreakfastCookies.addIngredient(banana);
        pbBreakfastCookies.addIngredient(egg);
        pbBreakfastCookies.addIngredient(oats);
        pbBreakfastCookies.addIngredient(peanutButter);
        pbBreakfastCookies.addIngredient(honey);
        pbBreakfastCookies.addIngredient(cinnamon);
        recipeRepository.save(pbBreakfastCookies);

        // Chicken satay salad

        Ingredient tamari = new Ingredient("Tamari Sauce", 1, 1, 0, 0, true, true, "1 tbs", 5.0);
        ingredientRepository.save(tamari);
        Ingredient curryPowder = new Ingredient("Curry Powder", 0.5, 1.7, 0.5, 1.7, true, true, "1 tsp", 10.0);
        ingredientRepository.save(curryPowder);
        Ingredient groundCumin = new Ingredient("Ground Cumin", 0, 1, 0, 0, true, true, "1 tsp", 10.0);
        ingredientRepository.save(groundCumin);
        Ingredient chickenBreast = new Ingredient("Chicken Breast", 36, 0, 1.6, 0, false, false, "150g", 159.0);
        ingredientRepository.save(chickenBreast);
        Ingredient limeJuice = new Ingredient("Lime Juice", 0, 0, 0, 0, true, true, "1tbs", 1.0);
        ingredientRepository.save(limeJuice);
        Ingredient littleGemLettuce = new Ingredient("Little Gem Lettuce", 0.4, 0.8, 0.2, 0.8, true, true, "1 heart", 8.0);
        ingredientRepository.save(littleGemLettuce);
        Ingredient cucumber = new Ingredient("Cucumber", 0.5, 2.5, 0.1, 0.3, true, true, "1/4", 10.0);
        ingredientRepository.save(cucumber);
        Ingredient pomegranate = new Ingredient("Pomegranate", 0.5, 9, 0.5, 2, true, true, "1/4", 40.0);
        ingredientRepository.save(pomegranate);
        Ingredient chilliSauce = new Ingredient("Chilli Sauce", 0.3, 14.3, 0.2, 0, true, true, "1tbs", 59.0);
        ingredientRepository.save(chilliSauce);

        Steps chickenSataySaladSteps = new Steps("Pour the tamari into a large dish and stir in the curry powder, cumin, garlic, and honey. Mix well.");
        stepsRepository.save(chickenSataySaladSteps);
        chickenSataySaladSteps.setStep2("Slice the chicken breasts in half horizontally to make 4 fillets in total, then add to the marinade and mix well to coat. Set aside in the fridge for one hour, or over night");
        chickenSataySaladSteps.setStep3("Meanwhile, mix the peanut butter with lime juice, chilli sauce and 1tbs water to make a sauce.");
        chickenSataySaladSteps.setStep4("Wipe a large non-stick pan with a little oil. Add the chicken and cook, covered with a lid, for 5-6 minutes on a medium heat, turning the fillets over for the last min, until cooked but still moist. set aside, covered, to rest for a few mins");
        chickenSataySaladSteps.setStep5("While the chicken rests, toss the lettuce wedges with the cucumber, onion, and pomegranate, and pile onto plates. Spoon over a little of the sauce. Slice teh chicken, pile on top of the salad and spoon over the remaining sauce.");
        stepsRepository.save(chickenSataySaladSteps);

        Recipe chickenSataySalad = new Recipe("Chicken Satay Salad", chickenSataySaladSteps, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chicken-satay-salad-8f5b068.jpg?quality=90&webp=true&resize=300,272");
        recipeRepository.save(chickenSataySalad);
        chickenSataySalad.addIngredient(tamari);
        chickenSataySalad.addIngredient(curryPowder);
        chickenSataySalad.addIngredient(groundCumin);
        chickenSataySalad.addIngredient(garlic);
        chickenSataySalad.addIngredient(honey);
        chickenSataySalad.addIngredient(chickenBreast);
        chickenSataySalad.addIngredient(peanutButter);
        chickenSataySalad.addIngredient(chilliSauce);
        chickenSataySalad.addIngredient(limeJuice);
        chickenSataySalad.addIngredient(oliveOil);
        chickenSataySalad.addIngredient(littleGemLettuce);
        chickenSataySalad.addIngredient(cucumber);
        chickenSataySalad.addIngredient(onion);
        chickenSataySalad.addIngredient(pomegranate);
        recipeRepository.save(chickenSataySalad);

        //Avocado and Strawberry smoothie

        Ingredient avocado = new Ingredient("Avocado", 1.4, 6, 10.3, 4.7, true, true, "1/2", 112.0);
        ingredientRepository.save(avocado);
        Ingredient strawberries = new Ingredient("Strawberries", 0, 4.2, 0.8, 0.8, true, true, "70g", 21.0);
        ingredientRepository.save(strawberries);
        Ingredient yoghurt = new Ingredient("Yoghurt", 2.6, 0.7, 0, 0, false, true, "25g", 13.0);
        ingredientRepository.save(yoghurt);
        Ingredient skimmedMilk = new Ingredient("Skimmed Milk", 5.4, 7.2, 2.6, 0, false, true, "150ml", 74.0);
        ingredientRepository.save(skimmedMilk);

        Steps avocadoAndStrawberrySmoothieSteps = new Steps("Put all the ingredients into a blender and whizz until smooth. If teh consistency is too thick, add a little water");
        stepsRepository.save(avocadoAndStrawberrySmoothieSteps);

        Recipe avocadoAndStrawberrySmoothie = new Recipe("Avocado and Strawberry Smoothie", avocadoAndStrawberrySmoothieSteps, "https://www.peelwithzeal.com/wp-content/uploads/2021/01/strawberry-avocado-smoothie-recipe-plant-based.jpg");
        recipeRepository.save(avocadoAndStrawberrySmoothie);
        avocadoAndStrawberrySmoothie.addIngredient(avocado);
        avocadoAndStrawberrySmoothie.addIngredient(strawberries);
        avocadoAndStrawberrySmoothie.addIngredient(yoghurt);
        avocadoAndStrawberrySmoothie.addIngredient(skimmedMilk);
        avocadoAndStrawberrySmoothie.addIngredient(limeJuice);
        avocadoAndStrawberrySmoothie.addIngredient(honey);
        recipeRepository.save(avocadoAndStrawberrySmoothie);

        // Prawn and Harissa spaghetti

        Ingredient longStemBroccoli = new Ingredient("Long-Stem Broccoli", 3.5, 4.7, 0, 2.4, true, true, "100g", 29.0);
        ingredientRepository.save(longStemBroccoli);
        Ingredient spaghetti = new Ingredient("Spaghetti", 4.6, 28.6, 0.6, 1.8, false, true, "80g", 141.0);
        ingredientRepository.save(spaghetti);
        Ingredient cherryTomatoes = new Ingredient("Cherry Tomatoes", 0.4, 1.9, 0.1, 0.6, true, true, "50g", 9.0);
        ingredientRepository.save(cherryTomatoes);
        Ingredient kingPrawns = new Ingredient("King Prawns", 11.3, 0, 0.5, 0, false, false,"50g", 50.0);
        ingredientRepository.save(kingPrawns);
        Ingredient harissaPaste = new Ingredient("Harissa Paste", 0, 0.4, 0.3, 0, true, true, "1tsp", 4.0);
        ingredientRepository.save(harissaPaste);
        Ingredient lemonZest = new Ingredient("Lemon Zest", 0, 0, 0, 0, true, true, "1/2 a lemon", 0.0);
        ingredientRepository.save(lemonZest);

        Steps prawnAndHarissaSpaghettiSteps = new Steps("Bring a pan of salted water to the boil. Add the broccoli and boil for 1 min, or until tender. Drain and set aside. Cook the pasta following the pack instructions, then drain, reserving a ladleful of cooking water");
        stepsRepository.save(prawnAndHarissaSpaghettiSteps);
        prawnAndHarissaSpaghettiSteps.setStep2("Heat the oil in a large frying pan, add the garlic clove and fry over a low heat for 2 mins. Remove with a slotted spoon and discard, leaving the flavoured oil");
        prawnAndHarissaSpaghettiSteps.setStep3("Add the tomatoes to the pan and fry over a medium heat for 5 mins. Stir through the prawns and cook for 2 mins. add the harissa and lemon zest, stirring to coat.");
        prawnAndHarissaSpaghettiSteps.setStep4("Toss the cooked spaghetti and pasta water through the prawns and harissa. Stir through the broccoli, season to taste and serve");
        stepsRepository.save(prawnAndHarissaSpaghettiSteps);

        Recipe prawnAndHarissaSpaghetti = new Recipe("Prawn and Harissa Spaghetti", prawnAndHarissaSpaghettiSteps, "https://www.telegraph.co.uk/content/dam/recipes/2020/08/28/sun-angela_1_trans_NvBQzQNjv4BqCM7LU2_bB37TtH8rnoO67rdzV2XcPKDLkZETSpG1-4U.jpg?imwidth=960");
        recipeRepository.save(prawnAndHarissaSpaghetti);
        prawnAndHarissaSpaghetti.addIngredient(longStemBroccoli);
        prawnAndHarissaSpaghetti.addIngredient(spaghetti);
        prawnAndHarissaSpaghetti.addIngredient(oliveOil);
        prawnAndHarissaSpaghetti.addIngredient(garlic);
        prawnAndHarissaSpaghetti.addIngredient(cherryTomatoes);
        prawnAndHarissaSpaghetti.addIngredient(kingPrawns);
        prawnAndHarissaSpaghetti.addIngredient(harissaPaste);
        prawnAndHarissaSpaghetti.addIngredient(lemonZest);
        recipeRepository.save(prawnAndHarissaSpaghetti);

        Steps easyBakedAppleChipsSteps = new Steps("Preheat oven to 225F and line a large baking sheet with parchment paper. Remove the apples core and slice each into thin rings or slices.");
        stepsRepository.save(easyBakedAppleChipsSteps);
        easyBakedAppleChipsSteps.setStep2("Place the apple slices in an even layer onto the baking sheet and sprinkle with cinnamon. Make sure the slices aren't crowded - this cause them to steam and they won't turn crispy.");
        easyBakedAppleChipsSteps.setStep3("Place the baking sheet into the oven and bake for 45 minutes or until crisp and golden. Allow to cool before serving.");
        stepsRepository.save(easyBakedAppleChipsSteps);

        Recipe easyBakedAppleChips = new Recipe("Easy Baked Apple Chips", easyBakedAppleChipsSteps, "https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2019/10/Apple-Chips-3.jpg");
        recipeRepository.save(easyBakedAppleChips);
        easyBakedAppleChips.addIngredient(apple);
        easyBakedAppleChips.addIngredient(cinnamon);
        recipeRepository.save(easyBakedAppleChips);

        Steps kingPrawnRisottoSteps = new Steps("Boil a pot of water and cook the pasta for 10 minutes.");
        stepsRepository.save(kingPrawnRisottoSteps);
        kingPrawnRisottoSteps.setStep2("While the pasta is cooking, heat the olive oil in a pan and brown the prawns for 2 minutes on each side.");
        kingPrawnRisottoSteps.setStep3("Add the milk and parmesan cheese to the pan and stir until thickened.");
        kingPrawnRisottoSteps.setStep4("Once cooked, add the pasta to the pan and stir together. Season with salt and pepper to taste. Serve hot");
        stepsRepository.save(kingPrawnRisottoSteps);

        Recipe kingPrawnRisotto = new Recipe("King Prawn Risotto", kingPrawnRisottoSteps, "http://thetalentzone.co.uk/musictv/wp-content/uploads/2015/12/lemon-resitto.png");
        recipeRepository.save(kingPrawnRisotto);
        kingPrawnRisotto.addIngredient(kingPrawns);
        kingPrawnRisotto.addIngredient(oliveOil);
        kingPrawnRisotto.addIngredient(skimmedMilk);
        kingPrawnRisotto.addIngredient(parmesanCheese);
        recipeRepository.save(kingPrawnRisotto);

        Steps eggAndBaconSteps = new Steps("Fry bacon in a pan until crispy.");
        stepsRepository.save(eggAndBaconSteps);
        eggAndBaconSteps.setStep2("Fry the egg in the same pan. Season with salt and pepper, add a little water and cover to steam. Serve hot.");

        Recipe eggAndBacon = new Recipe("Egg and Bacon", eggAndBaconSteps, "https://www.dishbydish.net/wp-content/uploads/Air-Fryer-Bacon-Gluten-Free-Dairy-Free_Final3-scaled.webp");
        recipeRepository.save(eggAndBacon);
        eggAndBacon.addIngredient(egg);
        eggAndBacon.addIngredient(bacon);
        recipeRepository.save(eggAndBacon);

        Steps bltSaladSteps = new Steps("Fry bacon in a pan until crispy.");
        stepsRepository.save(bltSaladSteps);
        bltSaladSteps.setStep2("Chop the lettuce and tomatoes and place in a bowl.");
        bltSaladSteps.setStep3("Chop the bacon into bits and sprinkle over the lettuce and tomatoes. Drizzle with olive oil and toss.");
        bltSaladSteps.setStep4("Season with salt and pepper to taste. Serve with a squeeze of lime.");
        stepsRepository.save(bltSaladSteps);

        Recipe bltSalad = new Recipe("BLT Salad", bltSaladSteps, "https://www.myketokitchen.com/wp-content/uploads/2020/01/Keto-BLT-Salad.jpg");
        recipeRepository.save(bltSalad);
        bltSalad.addIngredient(littleGemLettuce);
        bltSalad.addIngredient(cherryTomatoes);
        bltSalad.addIngredient(bacon);
        bltSalad.addIngredient(oliveOil);
        bltSalad.addIngredient(limeJuice);
        recipeRepository.save(bltSalad);

        Steps cheeseAndSpinachStuffedMushroomsSteps = new Steps("Add the olive oil and spinach to a hot pan and stir until wilted. Allow to cool");
        stepsRepository.save(cheeseAndSpinachStuffedMushroomsSteps);
        cheeseAndSpinachStuffedMushroomsSteps.setStep2("Mixed the spinach and Boursin in a bowl.");
        cheeseAndSpinachStuffedMushroomsSteps.setStep3("Wash the mushrooms and stuff the whole mushrooms with the spinach and Boursin mixture. Sprinkle parmesan cheese on top and a little salt and pepper");
        cheeseAndSpinachStuffedMushroomsSteps.setStep4("Place on a lined baking sheet and into the oven at 200F for 15-20 minutes. Serve Hot");
        stepsRepository.save(cheeseAndSpinachStuffedMushroomsSteps);

        Recipe cheeseAndSpinachStuffedMushrooms = new Recipe("Cheese And Spinach Stuffed Mushrooms", cheeseAndSpinachStuffedMushroomsSteps, "https://hips.hearstapps.com/hmg-prod/images/stuffed-mushrooms-vertical-jpg-1525207616.jpg?crop=1.00xw:0.667xh;0,0.215xh&resize=480:*");
        recipeRepository.save(cheeseAndSpinachStuffedMushrooms);
        cheeseAndSpinachStuffedMushrooms.addIngredient(portobelloMushroom);
        cheeseAndSpinachStuffedMushrooms.addIngredient(spinach);
        cheeseAndSpinachStuffedMushrooms.addIngredient(boursin);
        cheeseAndSpinachStuffedMushrooms.addIngredient(oliveOil);
        cheeseAndSpinachStuffedMushrooms.addIngredient(parmesanCheese);
        recipeRepository.save(cheeseAndSpinachStuffedMushrooms);

        //Added by Matt 13.12.22

        Steps spaghettiCarbonaraSteps = new Steps("In a small bowl, whisk the egg until well beaten. Mince the garlic, boil the water, chop the bacon and grate the cheese");
        stepsRepository.save(spaghettiCarbonaraSteps);
        spaghettiCarbonaraSteps.setStep2("Cook the pasta until al dente. Reserve some of the cooking water. Drain and toss with olive oil and keep warm.");
        spaghettiCarbonaraSteps.setStep3("Cook the bacon in a large pan until crispy, remove and drain on paper towels");
        spaghettiCarbonaraSteps.setStep4("Using the bacon fat in the pan, brown the onions and garlic. Return the bacon to the pan and add the pasta. Toss to combine, adding some of the reserve water if it seems dry.");
        spaghettiCarbonaraSteps.setStep5("Add the egg and toss with tongs until the pasta is coated. Add the cheese and repeat. Season with salt and pepper to taste then serve hot.");
        stepsRepository.save(spaghettiCarbonaraSteps);

        Recipe spaghettiCarbonara = new Recipe("Spaghetti Carbonara", spaghettiCarbonaraSteps, "https://www.kyleecooks.com/wp-content/uploads/2017/03/Spaghetti-Carbonara-22-1024x683.jpg");
        recipeRepository.save(spaghettiCarbonara);
        spaghettiCarbonara.addIngredient(bacon);
        spaghettiCarbonara.addIngredient(egg);
        spaghettiCarbonara.addIngredient(parmesanCheese);
        spaghettiCarbonara.addIngredient(spaghetti);
        spaghettiCarbonara.addIngredient(onion);
        spaghettiCarbonara.addIngredient(garlic);
        spaghettiCarbonara.addIngredient(oliveOil);
        recipeRepository.save(spaghettiCarbonara);

        Steps strawberryBananaSmoothieSteps = new Steps("Add all the ingredients into a blender with a cup of ice and blend until smooth. Serve cold.");
        stepsRepository.save(strawberryBananaSmoothieSteps);

        Recipe strawberryBananaSmoothie = new Recipe("Strawberry Banana Smoothie", strawberryBananaSmoothieSteps, "https://www.simplyscratch.com/wp-content/uploads/2011/03/5560399194_653b3c0b3c_o-620x414.jpg");
        recipeRepository.save(strawberryBananaSmoothie);
        strawberryBananaSmoothie.addIngredient(skimmedMilk);
        strawberryBananaSmoothie.addIngredient(strawberries);
        strawberryBananaSmoothie.addIngredient(banana);
        strawberryBananaSmoothie.addIngredient(yoghurt);
        strawberryBananaSmoothie.addIngredient(honey);
        strawberryBananaSmoothie.addIngredient(cinnamon);
        recipeRepository.save(strawberryBananaSmoothie);

        Steps cauliflowerBreakfastSkilletSteps = new Steps("Fry bacon in a skillet until crispy. Transfer to a plate to drain, then chop.");
        stepsRepository.save(cauliflowerBreakfastSkilletSteps);
        cauliflowerBreakfastSkilletSteps.setStep2("Chop the cauliflower into small chunks, dice the garlic and onion. Add these to the skillet with the bacon grease and cook for 5 minutes.");
        cauliflowerBreakfastSkilletSteps.setStep3("Make a well with a spoon and crack in the egg. Season with salt and pepper. Place the lid on the skillet and cook until the eggs set. About 3 minutes.");
        cauliflowerBreakfastSkilletSteps.setStep4("Sprinkle the diced bacon over the top and serve immediately.");
        stepsRepository.save(cauliflowerBreakfastSkilletSteps);

        Recipe cauliflowerBreakfastSkillet = new Recipe("Cauliflower Breakfast Skillet", cauliflowerBreakfastSkilletSteps, "https://www.loveandzest.com/wp-content/uploads/2017/02/Cauliflower-Breakfast-Skillet-Casserole-11-768x1152.jpg");
        recipeRepository.save(cauliflowerBreakfastSkillet);
        cauliflowerBreakfastSkillet.addIngredient(bacon);
        cauliflowerBreakfastSkillet.addIngredient(cauliflower);
        cauliflowerBreakfastSkillet.addIngredient(garlic);
        cauliflowerBreakfastSkillet.addIngredient(onion);
        cauliflowerBreakfastSkillet.addIngredient(egg);
        recipeRepository.save(cauliflowerBreakfastSkillet);

        Steps easyBananaPancakesSteps = new Steps("In a bowl combine the banana, egg and cinnamon. Mix/mash until smooth. Use a fork to make this easier.");
        stepsRepository.save(easyBananaPancakesSteps);
        easyBananaPancakesSteps.setStep2("Heat a pan under medium heat. Once hot pour two tablespoons of the batter into the pan and cook for 90 seconds each side or until ready. Serve hot or cold.");
        stepsRepository.save(easyBananaPancakesSteps);

        Recipe easyBananaPancakes = new Recipe("Easy Banana Pancakes", easyBananaPancakesSteps, "https://1.bp.blogspot.com/-y0wv6Pka_WM/WL6u-Gq93KI/AAAAAAAAFCM/RoffTFkVqQMFdOT7waNK2hTs41zk3hNrACLcB/s1600/1.jpg");
        recipeRepository.save(easyBananaPancakes);
        easyBananaPancakes.addIngredient(banana);
        easyBananaPancakes.addIngredient(cinnamon);
        easyBananaPancakes.addIngredient(egg);
        recipeRepository.save(easyBananaPancakes);

        Steps butternutSquashAndCurrySoupSteps = new Steps("Peel and chop the squash and onion. Coat in a pan with olive oil, salt and pepper. Place in a 220F oven for 30-40 minutes.");
        stepsRepository.save(butternutSquashAndCurrySoupSteps);
        butternutSquashAndCurrySoupSteps.setStep2("Remove from the oven and blend until smooth. Add to a pot with the stock, curry powder and 700ml boiling water.");
        butternutSquashAndCurrySoupSteps.setStep3("Bring to a boil and warm through. Serve hot.");
        stepsRepository.save(butternutSquashAndCurrySoupSteps);

        Recipe butternutSquashAndCurrySoup = new Recipe("Butternut Squash and Curry Soup", butternutSquashAndCurrySoupSteps, "https://cookieandkate.com/images/2019/10/best-butternut-squash-soup-recipe-2-768x1154.jpg");
        recipeRepository.save(butternutSquashAndCurrySoup);
        butternutSquashAndCurrySoup.addIngredient(squash);
        butternutSquashAndCurrySoup.addIngredient(oliveOil);
        butternutSquashAndCurrySoup.addIngredient(onion);
        butternutSquashAndCurrySoup.addIngredient(vegetableStockCube);
        butternutSquashAndCurrySoup.addIngredient(curryPowder);
        recipeRepository.save(butternutSquashAndCurrySoup);

        Steps applePieSmoothieSteps = new Steps("Place all the ingredients in a blender with a cup of ice and blend until smooth. Serve cold.");
        stepsRepository.save(applePieSmoothieSteps);

        Recipe applePieSmoothie = new Recipe("Apple Pie Smoothie", applePieSmoothieSteps, "https://www.acouplecooks.com/wp-content/uploads/2020/09/Apple-Smoothie-007.jpg");
        recipeRepository.save(applePieSmoothie);
        applePieSmoothie.addIngredient(apple);
        applePieSmoothie.addIngredient(cinnamon);
        applePieSmoothie.addIngredient(honey);
        recipeRepository.save(applePieSmoothie);








    }
}
