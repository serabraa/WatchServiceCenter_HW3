public class WatchService {
    public static void main(String[] args) {
//        replaceBattery("Quartz");
//        replaceBattery("Quar");
//        switchStrap(27.0f, 26.4f);
//        switchStrap(27.0f, 26.5f);
//        switchStrap(27.0f, 27.5f);
//        switchStrap(27.0f, 27.0f);
//        watchAccuracyCheck(0);
//        watchAccuracyCheck(100f);
//        watchAccuracyCheck(17.4f);
//        watchAccuracyCheck(-2.3f);
//        watchMagnetismCheck(100);
//        watchMagnetismCheck(87);
//        watchMagnetismCheck(-10000);
//        watchMagnetismCheck(0);
//        watchMagnetismCheck(90);
    }
//  checking if a watch has a battery for a replacement
//  true if it has a battery, else false
    public static boolean replaceBattery(String typeOfWatch) {
        if (typeOfWatch.equals("Quartz")) {
            System.out.println("Battery can be replaced for this type of watch.");
            return true;
        } else {
            System.out.println("Specified type of watch does not exist or it does not contain a battery!");
            return false;
        }
    }

//    checking if switching straps is possible. For it to work the new strap width needs to be in the interval of [widthOfWatchLugs -0.5,widthOfWatchLugs]
//    returns true if the straps can be switched, else false
    public static boolean switchStrap(float widthOfWatchLugs, float newStrapWidth) {
        if (widthOfWatchLugs - newStrapWidth <= 0.5 && widthOfWatchLugs - newStrapWidth >= 0) {
            System.out.println("Strap can be switched to the new one");
            return true;
        } else
            System.out.println("New strap is too large/small for the watch");
        return false;
    }

//     checking the accuracy of a watch
//    returns 1 if error is small and it satisfies the COSC standard
//    returns 2 if error is not that small, but also not critical
//    returns -1 if error is critical and the watch needs immidiate service
    public static int watchAccuracyCheck(float errorPerDayInSeconds) {
        if (errorPerDayInSeconds >= -4.0f && errorPerDayInSeconds <= 6.0f){//COSC standard
            System.out.println("Amazing! Your watch is very accurate, it satisfies the COSC standard");
            return 1;
        }if(errorPerDayInSeconds >=-15.0f &&errorPerDayInSeconds<=15.0f){
            System.out.println("Ok! Your watch's accuracy is acceptable");
            return 2;
        }else
            System.out.println("Your watch is very inaccurate, it needs a service!");
        return -1;
    }

//    checking the magnetic condition of a watch
//    returns -1 if the conditionPercentage was entered invalid
//    returns 0 if watch does not need a de-magnetisation
//    returns 1 if watch needs a de-magnetisation
    public static int watchMagnetismCheck(float conditionOfPartsInPercentage){
        if(conditionOfPartsInPercentage<0f || conditionOfPartsInPercentage>100.0f){
            System.out.println("Invalid input!");
            return -1;//invalid
        }
        if (conditionOfPartsInPercentage>=87.5f){
            System.out.println("Watch is in a good condition and does not need de-magnetisation service!");
            return 0;//no need
        } else
            System.out.println("Watch needs a de-magnetisation service!");
        return 1;//needs
    }

}
