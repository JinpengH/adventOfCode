import java.io.*;
import java.util.*;

public class Day
{
    public Day(){}
    public void run(int i)
    {
        switch(i){
            case 1:
                day1();
                day1ex();
                break;
            case 2:
                day2();
                break;
            case 3:
                day3();
                break;
            case 4:
                day4();
                break;
            case 5:
                day5();
                break;
            case 6:
                day6();
                break;
            case 7:
                day7();
                break;
            case 8:
                day8();
                break;
            case 9:
                day9();
                break;
            case 10:
                day10();
                break;
            case 11:
                day11();
                day11EX();
                break;
            case 12:
                day12();
                day12EX();
                break;
            case 13:
                day13();
                break;
            case 14:
                day14();
                day14EX();
                break;
            case 15:
                day15();
                break;
            default:
                break;
        }
    }

    private void day1()
    {
        //给出一系列数字，找出两者之和为2020的数字对，返回他们的乘积
        //Space O(n) Time O(n)
        File file = new File("day1.txt");
        HashSet<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            while((str = reader.readLine()) != null)
            {
                int i = Integer.parseInt(str);
                int rev = 2020 - i;
                if(set.contains(rev))
                {
                    System.out.println("DAY1: " + rev*i);
                }
                else
                {
                    set.add(i);
                }
            }
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day1ex()
    {
        //给出一系列数字，找出三者之和为2020的数字对，返回他们的乘积
        //Space O(n) Time O(n2)
        File file = new File("day1.txt");
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            while((str = reader.readLine()) != null)
            {
                int i = Integer.parseInt(str);
                arr.add(i);
                set.add(i);
            }
            for(int i = 0; i < arr.size(); i++)
            {
                for(int j = i+1; j < arr.size(); j++)
                {
                    int rev = 2020 - arr.get(i) - arr.get(j);
                    if(set.contains(rev))
                    {
                        System.out.println("DAY1ex: " + rev*arr.get(i)*arr.get(j));
                        return;
                    }
                }
            }
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day2()
    {
        File file = new File("day2.txt");
        HashSet<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            int max = -1;
            int min = -1;
            char reg = ' ';
            int total = 0;
            int totalEX = 0;
            while((str = reader.readLine()) != null)
            {
                max = -1;
                min = -1;
                String[] s = str.split(":");
                String password = s[1].substring(1);
                StringBuilder sb = new StringBuilder();
                for(char c : s[0].toCharArray())
                {
                    if(max != -1 && min != -1){reg = c;}
                    else if(c == '-'){min = Integer.parseInt(sb.toString()); sb = new StringBuilder();}
                    else if(c == ' '){max = Integer.parseInt(sb.toString());}
                    else{sb.append(c);}
                }
                if(day2Helper(min,max,reg,password)){total++;}
                if(day2EXHelper(min,max,reg,password)){totalEX++;}
            }
            System.out.println("DAY2: " + total);
            System.out.println("DAY2EX: " + totalEX);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }
    }

    private boolean day2Helper(int min, int max, char reg, String password)
    {
        int total = 0;
        for(char c : password.toCharArray())
        {
            if(c == reg){total++;}
        }
        return total >= min && total <= max;
    }

    private boolean day2EXHelper(int min, int max, char reg, String password)
    {
        return password.charAt(min-1) == reg ^ password.charAt(max-1) == reg;
    }

    private void day3()
    {
        File file = new File("day3.txt");
        HashSet<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            int i1 = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            long s1 = 0;
            long s2 = 0;
            long s3 = 0;
            long s4 = 0;
            long s5 = 0;

            int times = 0;
            while((str = reader.readLine()) != null)
            {
                if(str.charAt(i1) == '#'){s1++;}
                if(str.charAt(i2) == '#'){s2++;}
                if(str.charAt(i3) == '#'){s3++;}
                if(str.charAt(i4) == '#'){s4++;}
                if(times%2 == 0 && str.charAt(i5) == '#'){s5++;}
                int len = str.length();
                i1 = (i1 + 1) % len;
                i2 = (i2 + 3) % len;
                i3 = (i3 + 5) % len;
                i4 = (i4 + 7) % len;
                if(times % 2 == 0)
                {
                    i5 = (i5 + 1) % len;
                }
                times++;
            }
            System.out.println("DAY3: " + s2);
            System.out.println("DAY3EX: " + s1 * s2 * s3 * s4 * s5);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }
    }

    private void day4()
    {
        File file = new File("day4.txt");
        HashSet<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            int total = 0;
            int counter = 0;
            int totalEX = 0;
            int counterEX = 0;
            while((str = reader.readLine()) != null)
            {
                //System.out.println(str);
                if(str.equals(""))
                {
                    if(counter >= 7) total++;
                    if(counterEX >= 7) totalEX++;

                    counter = 0;
                    counterEX = 0;
                }
                else
                {
                    String[] split = str.split(" ");
                    for(String s : split)
                    {
                        String cred = s.substring(0,3);
                        String value = s.substring(4);
                        int val = 0;
                        if(!cred.equals("cid")){counter++;}
                        int prev = counterEX;
                        switch (cred)
                        {
                            case "byr":
                                if(value.length() != 4){break;}
                                val = Integer.parseInt(value);
                                if(val >= 1920 && val <= 2002){counterEX++;}
                                break;
                            case "iyr":
                                if(value.length() != 4){break;}
                                val = Integer.parseInt(value);
                                if(val >= 2010 && val <= 2020){counterEX++;}
                                break;
                            case "eyr":
                                if(value.length() != 4){break;}
                                val = Integer.parseInt(value);
                                if(val >= 2020 && val <= 2030){counterEX++;}
                                break;
                            case "hgt":
                                String measure = value.substring(value.length()-2);
                                if(!measure.equals("cm") && !measure.equals("in")){break;}
                                val = Integer.parseInt(value.substring(0,value.length()-2));
                                if(measure.equals("cm") && val >= 150 && val <= 193){counterEX++;}
                                if(measure.equals("in") && val >= 59 && val <= 76){counterEX++;}
                                break;
                            case "hcl":
                                if(value.matches("#[a-f0-9]{6}")){counterEX++;}
                                break;
                            case "ecl":
                                if(value.equals("amb") || value.equals("blu") ||value.equals("brn") ||value.equals("gry") ||value.equals("grn") ||value.equals("hzl") ||value.equals("oth"))
                                {counterEX++;}
                                break;
                            case "pid":
                                if(value.length() == 9){counterEX++;}
                                break;
                            default:
                                break;

                        }
                        /*if(counterEX == prev){
                            System.out.println("NOT PASSED: ");
                            System.out.println("CRED: " + cred);
                            System.out.println("VALUE: " + value);
                        }*/

                    }
                }

            }
            if(counter >= 7) total++;
            if(counterEX >= 7) totalEX++;
            System.out.println("DAY4: " + total);
            System.out.println("DAY4EX: " + totalEX);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }
    }

    private void day5()
    {
        File file = new File("day5.txt");
        HashSet<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            int max = 0;
            while((str = reader.readLine()) != null)
            {
                int row = 0;
                int col = 0;
                for(int i = 0; i < 7; i++)
                {
                    if(str.charAt(i) == 'B'){row++;}
                    row = row << 1;
                }
                for(int i = 7; i < 10;i++)
                {
                    if(str.charAt(i) == 'R'){col++;}
                    col = col << 1;
                }
                row = row >> 1;
                col = col >> 1;
                set.add(row*8+col);
                max =  Math.max(max, row*8+col);
            }
            for(int i = 8; i <= 970; i++)
            {
                if(!set.contains(i)){System.out.println("DAY5EX: " + i);}
            }
            System.out.println("DAY5: " + max);

        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day6()
    {
        File file = new File("day6.txt");

        try
        {
            HashSet<Character> set = new HashSet<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            int total = 0;
            int totalEX = 0;
            int line = 0;
            int[] alp = new int[26];
            while((str = reader.readLine()) != null)
            {
                if(str.equals(""))
                {
                    total = total + set.size();
                    set = new HashSet<>();
                    for(int i : alp)
                    {
                        if(i == line){totalEX++;}
                    }
                    line = 0;
                    alp = new int[26];
                }
                else
                {
                    for(char c : str.toCharArray())
                    {
                        set.add(c);
                        alp[c-'a']++;
                    }
                    line++;
                }
            }
            //total = total + set.size();
            System.out.println("DAY6: " + total);
            System.out.println("DAY6EX: " + totalEX);

        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day7()
    {
        File file = new File("day7.txt");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            HashMap<String, Set<String>> outMap = new HashMap<>();
            HashMap<String, Map<String, Integer>> inMap = new HashMap<>();
            HashSet<String> set = new HashSet<>();


            while((str = reader.readLine()) != null)
            {
                bagParser(str, outMap, inMap);
            }


            Queue<String> queue = new LinkedList<>();
            queue.offer("shiny gold");


            while(!queue.isEmpty())
            {

                String bag = queue.poll();
                //System.out.println("DEBUG: " + bag);
                set.add(bag);
                if(outMap.get(bag) == null){continue;}
                for(String s : outMap.get(bag))
                {
                    if(!set.contains(s)){queue.add(s);set.add(s);}
                }
            }

            HashMap<String, Integer> mem = new HashMap<>();
            String tar = "shiny gold";

            int totalEX = getBags(tar, inMap, mem);
            for(Map.Entry<String, Integer> entry : mem.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println("DAY7: " + (set.size()-1));
            System.out.println("DAY7EX: " + (totalEX - 1));
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void bagParser(String str, HashMap<String, Set<String>> outMap, HashMap<String, Map<String, Integer>> inMap)
    {
        String[] strArr = str.split(" ");
        String container = strArr[0] + " " + strArr[1];
        if(strArr[4].equals("no")){return;}
        for(int i = 5; i < strArr.length-1; i+=4)
        {
            String contained = strArr[i] + " " + strArr[i+1];
            if(!outMap.containsKey(contained)){outMap.put(contained, new HashSet<String>());}
            if(!inMap.containsKey(container)){inMap.put(container, new HashMap<String, Integer>());}
            outMap.get(contained).add(container);
            inMap.get(container).put(contained, Integer.parseInt(strArr[i-1]));
            //System.out.println("DEBUG: " + container + " contains " + strArr[i-1] + " "+ contained);
            //System.out.println("DEBUG: " + container + " contains " + contained);
        }
    }

    private int getBags(String str, HashMap<String, Map<String, Integer>> inMap, Map<String, Integer> mem)
    {
        if(!inMap.containsKey(str)){return 1;}
        int total = 1;
        for(Map.Entry<String, Integer> entry : inMap.get(str).entrySet())
        {
            total += entry.getValue() * getBags(entry.getKey(), inMap, mem);
        }
        mem.put(str,total);
        return total;
    }

    private void day8()
    {
        File file = new File("day8.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            ArrayList<String> list = new ArrayList<>();
            while((str = reader.readLine()) != null)
            {
                list.add(str);
            }


            Set<Integer> set = new HashSet<>();
            int i = 0;
            int acc = 0;
            while(!set.contains(i))
            {
                String instruction = list.get(i).substring(0,3);
                int op = Integer.parseInt(list.get(i).substring(4));
                set.add(i);
                switch (instruction) {
                    case "nop":
                        i++;
                        break;
                    case "acc":
                        i++;
                        acc += op;
                        break;
                    case "jmp":
                        i += op;
                        break;
                }
            }
            System.out.println("DAY8: " + acc);


            i = 0;
            acc = 0;
            boolean flag = false;
            while(i <= list.size() || flag)
            {
                String instruction = list.get(i).substring(0,3);
                int op = Integer.parseInt(list.get(i).substring(4));
                set.add(i);
                switch (instruction) {
                    case "nop":
                        if(!set.contains(i+op))
                        {
                            int res = testRun(i+op,acc,list,set);
                            if (res != -1)
                            {
                                flag = true;
                                System.out.println("DAY8EX: " + res);
                            }
                        }
                        i++;
                        break;
                    case "acc":
                        i++;
                        acc += op;
                        break;
                    case "jmp":
                        if(!set.contains(i+1))
                        {
                            int res = testRun(i+1,acc,list,set);
                            if (res != -1)
                            {
                                flag = true;
                                System.out.println("DAY8EX: " + res);
                            }
                        }
                        i += op;
                        break;
                }
            }

        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private int testRun(int i, int acc, List<String> list, Set<Integer> set)
    {
        while(i < list.size())
        {
            if(set.contains(i)){return -1;}
            String instruction = list.get(i).substring(0,3);
            int op = Integer.parseInt(list.get(i).substring(4));
            set.add(i);
            switch (instruction) {
                case "nop":
                    i++;
                    break;
                case "acc":
                    i++;
                    acc += op;
                    break;
                case "jmp":
                    i += op;
                    break;
            }
        }
        return acc;
    }

    private void day9()
    {
        File file = new File("day9.txt");
        boolean flag = true;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            Set<Long> set = new HashSet<>();
            Queue<Long> queue = new LinkedList<>();
            List<Long> list = new ArrayList<>();
            long par = 0;
            while((str = reader.readLine()) != null && flag)
            {
                par = Long.parseLong(str);
                list.add(par);
                if(set.size() < 25)
                {
                    set.add(par);
                    queue.offer(par);
                }
                else
                {
                    boolean isPaired = false;
                    for(int i = 0; i < 25; i++)
                    {
                        long popped = queue.poll();
                        //System.out.println("DEBUG: removed " + popped);
                        queue.offer(popped);
                        if(set.contains(par-popped) && !isPaired)
                        {
                            //System.out.println("DEBUG: Paired " + popped + " " + (par-popped));
                            isPaired = true;
                        }
                    }
                    if(!isPaired){
                        System.out.println("DAY9: " + par);
                        flag = false;
                    }
                    long k = queue.poll();
                    //System.out.println("DEBUG: removed " + k);
                    set.remove(k);
                    set.add(par);
                    queue.offer(par);

                }
            }

            //EX
            List<Long> sum = new ArrayList<>();
            long s = 0;
            for(int i = 0; i < list.size()-1; i++)
            {
                s = s + list.get(i);
                sum.add(s);
            }
            for(int i = 0; i < sum.size()-1; i++)
            {
                for(int j = i+1; j < sum.size(); j++)
                {
                    if(sum.get(j) - sum.get(i) == par)
                    {
                        System.out.println("DAY9EX: " + (i+1) + " " + j);
                        break;
                    }
                }
            }
            long min = list.get(570);
            long max = list.get(554);
            for(int i = 554; i <= 570; i++)
            {
                min = Math.min(list.get(i),min);
                max = Math.max(list.get(i),max);
            }
            System.out.println(min+max);

        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day10()
    {
        File file = new File("day10.txt");
        int max = 0;
        Set<Integer> set = new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;

            max = 0;
            while((str = reader.readLine()) != null)
            {
                int par = Integer.parseInt(str);
                set.add(par);
                max = Math.max(max,par);
            }
            int i = 0;
            int diffOne = 0;
            int diffThree = 1;
            while(i != max)
            {
                if(set.contains(i+1))
                {
                    diffOne++;
                    i++;
                }
                else if(set.contains(i+2))
                {
                    i+=2;
                }
                else
                {
                    diffThree++;
                    i+=3;
                }
            }
            System.out.println("DAY10: " + diffOne * diffThree);


            //EX

            System.out.println("DAY10EX: " + day10Helper(0, set, max, new HashMap<Integer, Long>()));
        }




        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private long day10Helper(int i, Set<Integer> set, int max, Map<Integer, Long> map)
    {
        if(i == max){return 1;}
        if(map.containsKey(i)){return map.get(i);}
        long sum = 0;
        if(set.contains(i+1))
        {
            sum += day10Helper(i+1, set, max, map);
        }
        if(set.contains(i+2))
        {
            sum += day10Helper(i+2, set, max, map);
        }
        if(set.contains(i+3))
        {
            sum += day10Helper(i+3, set, max, map);
        }
        map.put(i,sum);
        return sum;
    }

    private void day11()
    {
        File file = new File("day11.txt");

        try
        {
            //init
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            List<List<Character>> board = new ArrayList<>();
            boolean flag = true;
            int len = 0;
            while((str = reader.readLine()) != null)
            {
                if(flag)
                {
                    flag = false;
                    len = str.length() + 2;
                    List<Character> list = new ArrayList<>(len);
                    for(int i = 0; i < len; i++){list.add('.');}
                    board.add(list);
                }
                List<Character> list = new ArrayList<>(len);
                list.add('.');
                for(char c : str.toCharArray()){list.add(c);}
                list.add('.');
                board.add(list);
            }
            List<Character> list = new ArrayList<>(len);
            for(int i = 0; i < len; i++){list.add('.');}
            board.add(list);


            //no
            boolean isChanged = true;
            int count = 0;
            while(isChanged) {

                List<List<Character>> newBoard = new LinkedList<>();
                List<Character> newList = new ArrayList<>(len);
                for(int j = 0; j < board.size(); j++)
                {
                    newList = new ArrayList<>(len);
                    for (int i = 0; i < len; i++)
                    {
                        newList.add('.');
                    }
                    newBoard.add(newList);
                }

                isChanged = false;
                count = 0;
                for (int i = 1; i < board.size() - 1; i++) {
                    for (int j = 1; j < board.get(0).size() - 1; j++) {
                        int occCount = 0;
                        char set = board.get(i).get(j);
                        if (board.get(i - 1).get(j - 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i).get(j - 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i + 1).get(j - 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i - 1).get(j + 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i).get(j + 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i + 1).get(j + 1) == '#') {
                            occCount++;
                        }
                        if (board.get(i - 1).get(j) == '#') {
                            occCount++;
                        }
                        if (board.get(i + 1).get(j) == '#') {
                            occCount++;
                        }
                        if (board.get(i).get(j) == 'L' && occCount == 0) {
                            set = '#';
                            isChanged = true;
                        }
                        if (board.get(i).get(j) == '#' && occCount >= 4) {
                            set = 'L';
                            isChanged = true;
                        }
                        newBoard.get(i).set(j,set);
                        if(set == '#'){count++;}
                    }
                }
                board = newBoard;
            }

            System.out.println("DAY11: " + count);



        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day11EX()
    {
        File file = new File("day11.txt");

        try
        {
            //init
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            List<List<Character>> board = new ArrayList<>();
            boolean flag = true;
            int len = 0;
            while((str = reader.readLine()) != null)
            {
                if(flag)
                {
                    flag = false;
                    len = str.length() + 2;
                    List<Character> list = new ArrayList<>(len);
                    for(int i = 0; i < len; i++){list.add('.');}
                    board.add(list);
                }
                List<Character> list = new ArrayList<>(len);
                list.add('.');
                for(char c : str.toCharArray()){list.add(c);}
                list.add('.');
                board.add(list);
            }
            List<Character> list = new ArrayList<>(len);
            for(int i = 0; i < len; i++){list.add('.');}
            board.add(list);


            //ex
            boolean isChanged = true;
            int count = 0;
            while(isChanged) {

                List<List<Character>> newBoard = new LinkedList<>();
                List<Character> newList = new ArrayList<>(len);
                for(int j = 0; j < board.size(); j++)
                {
                    newList = new ArrayList<>(len);
                    for (int i = 0; i < len; i++)
                    {
                        newList.add('.');
                    }
                    newBoard.add(newList);
                }

                isChanged = false;
                count = 0;
                for (int i = 1; i < board.size() - 1; i++) {
                    for (int j = 1; j < board.get(0).size() - 1; j++) {
                        int occCount = 0;
                        char set = board.get(i).get(j);
                        if (day11Helper(board, i, j, 1, 1)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, 1, 0)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, 1, -1)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, 0, 1)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, 0, -1)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, -1, 1)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, -1, 0)) {
                            occCount++;
                        }
                        if (day11Helper(board, i, j, -1, -1)) {
                            occCount++;
                        }
                        if (board.get(i).get(j) == 'L' && occCount == 0) {
                            set = '#';
                            isChanged = true;
                        }
                        if (board.get(i).get(j) == '#' && occCount >= 5) {
                            set = 'L';
                            isChanged = true;
                        }
                        newBoard.get(i).set(j,set);
                        if(set == '#'){count++;}
                    }
                }
                board = newBoard;
            }

            System.out.println("DAY11EX: " + count);



        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private boolean day11Helper(List<List<Character>> board, int row, int col, int i, int j)
    {
        row += i;
        col += j;
        while(row < board.size() && row >= 0 && col < board.get(0).size() && col >= 0)
        {

            if(board.get(row).get(col) == '#'){return true;}
            else if(board.get(row).get(col) == 'L'){return false;}
            row += i;
            col += j;
        }
        return false;
    }

    private void day12()
    {
        //init
        File file = new File("day12.txt");
        char[] dir = new char[]{'E','S','W','N'};
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            int diag = 0;
            int hor = 0;
            int currDir = 0;
            while((str = reader.readLine()) != null)
            {
                char ins = str.charAt(0);
                int f = Integer.parseInt(str.substring(1));
                if(ins == 'F'){ins = dir[currDir];}
                switch (ins)
                {
                    case 'E':
                        diag += f;
                        break;
                    case 'S':
                        hor += f;
                        break;
                    case 'W':
                        diag -= f;
                        break;
                    case 'N':
                        hor -= f;
                        break;
                    case 'R':
                        currDir += f/90;
                        currDir += 4;
                        currDir = currDir%4;
                        break;
                    case 'L':
                        currDir -= f/90;
                        currDir += 4;
                        currDir = currDir%4;
                        break;
                }
            }

            System.out.println("DAY12: " + (Math.abs(diag) + Math.abs(hor)));
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day12EX()
    {
        //init
        File file = new File("day12.txt");
        char[] dir = new char[]{'E','S','W','N'};
        int[] waypoint = new int[]{10, 1};
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            int diag = 0;
            int hor = 0;
            int currDir = 0;
            while((str = reader.readLine()) != null)
            {
                char ins = str.charAt(0);
                int f = Integer.parseInt(str.substring(1));
                int[] res;
                switch (ins)
                {
                    case 'E':
                        waypoint[0] += f;
                        break;
                    case 'S':
                        waypoint[1] -= f;
                        break;
                    case 'W':
                        waypoint[0] -= f;
                        break;
                    case 'N':
                        waypoint[1] += f;
                        break;
                    case 'F':
                        diag += waypoint[0] * f;
                        hor += waypoint[1] * f;
                        break;
                    case 'R':
                        f = f/90;
                        waypoint = day12Helper(f, waypoint[0], waypoint[1]);
                        break;
                    case 'L':
                        f = -f/90;
                        waypoint = day12Helper(f, waypoint[0], waypoint[1]);
                        break;
                }
            }

            System.out.println("DAY12EX: " + (Math.abs(diag) + Math.abs(hor)));
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private int[] day12Helper(int i, int diag, int hor)
    {
        //System.out.println("diag: " + diag);
        //System.out.println("hor: " + hor);

        if(i < 0){i += 4;}
        i = i % 4;
        //System.out.println(i);
        for(int j = 0; j < i; j++)
        {
            int middle = diag;
            diag = hor;
            hor = -middle;
        }
        //System.out.println("diag: " + diag);
        //System.out.println("hor: " + hor);
        return new int[]{diag,hor};

    }

    private void day13()
    {
        File file = new File("day13.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int timestamp;
            timestamp = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            String[] strArr = str.split(",");
            int minDiff = Integer.MAX_VALUE;
            int minBus = 0;
            int x = 0;
            for(String s : strArr)
            {
                if(s.equals("x")){x++;continue;}
                else{
                    System.out.println(x);
                    x++;
                }
                int i = Integer.parseInt(s);
                int diff = i - timestamp % i;
                if(diff == i){diff = 0;}
                if(diff < minDiff)
                {
                    minDiff = diff;
                    minBus = i;
                }
            }
            System.out.println("DAY13: " + minBus * minDiff);


        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day14()
    {
        File file = new File("day14.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            long andMask = 0;
            long orMask = 0;
            Map<Integer, Long> map = new HashMap<>();
            while((str = reader.readLine()) != null)
            {
                if(str.substring(0,4).equals("mask"))
                {
                    andMask = 0;
                    orMask = 0;
                    for(char c: str.substring(7).toCharArray())
                    {
                        andMask++;
                        if(c == '1')
                        {
                            orMask++;
                        }
                        else if(c == '0')
                        {
                            andMask--;
                        }
                        orMask = orMask << 1;
                        andMask = andMask << 1;
                    }
                    orMask = orMask >> 1;
                    andMask = andMask >> 1;
                }
                else
                {
                    String[] strArr = str.split(" ");
                    int number = Integer.parseInt(strArr[2]);
                    int key = Integer.parseInt(strArr[0].substring(4,strArr[0].length()-1));
                    //System.out.println("DEBUG: number: " + number + " key: " + key);
                    long handle = (number & andMask) | orMask;
                    map.put(key,handle);
                    //System.out.println(handle);
                }
            }

            long sum = 0;
            for(Map.Entry<Integer, Long> entry : map.entrySet())
            {
                sum += entry.getValue();
            }
            System.out.println("DAY14: " + sum);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void day14EX()
    {
        File file = new File("day14.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            String mask = "";
            Map<Long, Integer> map = new HashMap<>();
            while((str = reader.readLine()) != null)
            {
                if(str.substring(0,4).equals("mask"))
                {
                    mask = str.substring(7);
                }
                else
                {
                    String[] strArr = str.split(" ");
                    int number = Integer.parseInt(strArr[2]);
                    int key = Integer.parseInt(strArr[0].substring(4,strArr[0].length()-1));
                    //System.out.println("DEBUG: number: " + number + " key: " + key);
                    List<Long> list = day14Helper(mask, key);
                    for(Long i : list){map.put(i,number);}
                    //System.out.println(handle);
                }
            }

            long sum = 0;
            for(Map.Entry<Long, Integer> entry : map.entrySet())
            {
                sum += entry.getValue();
            }
            System.out.println("DAY14: " + sum);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private List<Long> day14Helper(String mask, int number)
    {

        List<Long> list = new ArrayList<>();
        list.add((long)0);
        String bin = Integer.toBinaryString(number);
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, mask.length() - bin.length())));
        sb.append(bin);
        String padded = sb.toString();
        List<Long> newList = new ArrayList<>();
        for(int i = 0; i < mask.length(); i++)
        {
            switch (mask.charAt(i))
            {
                case '0':
                    newList = new ArrayList<>();
                    for(Long l : list)
                    {
                        if(padded.charAt(i) == '1'){l+=1;}
                        l = l << 1;
                        newList.add(l);
                    }
                    list = newList;
                    break;
                case '1':
                    newList = new ArrayList<>();
                    for(Long l : list)
                    {
                        l+=1;
                        l = l << 1;
                        newList.add(l);
                    }
                    list = newList;
                    break;
                case 'X':
                    newList = new ArrayList<>();
                    for(Long l : list)
                    {
                        long m = (l+1) << 1;
                        newList.add(m);
                        l = l << 1;
                        newList.add(l);
                    }
                    list = newList;
                    break;
            }
        }
        for(Long l : list)
        {
            l = l >> 1;
            System.out.println("DEBUG: list: " + l);
        }
        return list;
    }

    private void day15()
    {
        File file = new File("day15.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            HashMap<Integer, int[]> map = new HashMap<>();

            String str;
            int i = 0;
            int prev = 0;
            while((str = reader.readLine()) != null)
            {
                String[] strArr = str.split(",");
                for(i = 0; i < strArr.length; i++)
                {
                    int tr = Integer.parseInt(strArr[i]);
                    map.put(tr, new int[]{i+1, -1});
                    prev = tr;
                }
            }
            i++;
            for(;i <= 30000000; i++)
            {
                if(map.get(prev)[1] == -1){prev = 0;}
                else{prev = map.get(prev)[0] - map.get(prev)[1];}
                if(map.containsKey(prev))
                {
                    int first = i;
                    int second = map.get(prev)[0];
                    map.put(prev, new int[]{first,second});
                }
                else{map.put(prev,new int[]{i, -1});}
                //System.out.println("DEBUG: " + i + ": " + prev);
            }

            System.out.println("DAY15: " + prev);


        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }

    private void dayEX()
    {
        File file = new File("day6.txt");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while((str = reader.readLine()) != null)
            {


            }
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Cannot find the file");
        }
        catch (IOException ioe)
        {
            System.out.println("Read error");
        }

    }


}