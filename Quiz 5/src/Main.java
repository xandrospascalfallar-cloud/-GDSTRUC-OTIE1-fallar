public class Main
{
    public static void main(String[] args)
    {
        int[] numbers = {24, 10, 35, 47, 59, 67, 78, 81, 99};
        int searchNumber = 67;

        int foundIndex = findNumber(numbers, searchNumber);

        if (foundIndex == -1)
        {
            System.out.println("Number not found!");
        }
        else
        {
            System.out.println("Number found at position: " + foundIndex);
        }
    }

    public static int findNumber(int[] nums, int value)
    {
        /*
         * Data Set:
         * The array does not need to be sorted.
         *
         * Steps:
         * 1. Check each number starting from the beginning.
         * 2. Compare it with the number we want to find.
         * 3. If they are the same, return the current index.
         * 4. Otherwise, continue checking.
         * 5. Return -1 if the number is not found.
         *
         * Time Complexity:
         * O(n) because it might check all the numbers.
         */

        int position = 0;

        while (position < nums.length)
        {
            if (nums[position] == value)
            {
                return position;
            }

            position++;
        }

        return -1;
    }
}