class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // Days elapsed in previous full years (1971 to year - 1)
        int totalDays = 0;
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Days elapsed in previous full months of the current year
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }

        // Add the current month's days
        totalDays += day;

        // January 1, 1971 was a Friday. 
        // Mapping index offset: (totalDays + 4) % 7 where 0 = Sunday, 5 = Friday for Day 1
        return days[(totalDays + 4) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}