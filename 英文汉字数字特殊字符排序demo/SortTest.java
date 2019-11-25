
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTest {
    public static void main(String[] args) {
        List<Students> students = new ArrayList<Students>();
        students.add(new Students(23, 100,"a里azj001"));
        students.add(new Students(23, 100,"阿里azj001"));
        students.add(new Students(23, 100,"abazj001"));
        students.add(new Students(27, 98,"腾讯bzj002"));
        students.add(new Students(29, 99,"百度dzj003"));
        students.add(new Students(29, 98,"华为czj004"));
        students.add(new Students(22, 89,"择天ezj005"));

        students.add(new Students(22, 89,"a择天ezj005"));
        students.add(new Students(22, 89,"a择b天ezj005"));
        students.add(new Students(22, 89,"A择天ezj005"));

        students.add(new Students(22, 89,"8择天ezj005"));
        students.add(new Students(22, 89,"0择天ezj005"));

        students.add(new Students(22, 89,"z择天ezj005"));

        students.add(new Students(22, 89,"_z择天ezj005"));
        students.add(new Students(22, 89,"_a择天ezj005"));
        students.add(new Students(22, 89,"*_z择天ezj005"));
        students.add(new Students(22, 89,"__z择天ezj005"));
        students.add(new Students(22, 89,"%_z择天ezj005"));
        students.add(new Students(22, 89,"-_z择天ezj005"));
        List<Students> symbolList = new ArrayList<>();
        List<Students> sList = new ArrayList<>();
        Map<Boolean, List<Students>> listMap = students.stream().collect(Collectors.partitioningBy(p -> {
            String templateName = PinyinUtils.ToPinyinAndGetFirstChar(p.getName());
            char c = templateName.substring(0, 1).charAt(0);
            int asc = Integer.valueOf(c);
            if ((asc > 64 && asc < 91) || (asc > 112 && asc < 123) || (asc >= 47 && asc < 58)) {
                return true;
            } else {
                return false;
            }
        }));
        if (CollectionUtils.isNotEmpty(listMap.get(true))){
            Collections.sort(listMap.get(true), new Comparator<Students>() {
                @Override
                public int compare(Students o1, Students o2) {
                    Students newo1 = new Students();
                    newo1.setName(PinyinUtils.ToPinyinAndGetFirstChar(o1.getName()));
                    Students newo2 = new Students();
                    newo2.setName(PinyinUtils.ToPinyinAndGetFirstChar(o2.getName()));
                    int minLength = newo1.getName().length() < newo2.getName().length() ? newo1.getName().length() : newo2.getName().length();
                    int diff = 0;
                    for (int i=0;i<minLength-1;i++){
                        diff = newo1.getName().substring(i, i+1).compareTo(newo2.getName().substring(i, i+1));
                        if (diff != 0){
                            break;
                        }
                    }
                    return diff;
                }
            });
            students.clear();
            students.addAll(listMap.get(true));
        }
        if (CollectionUtils.isNotEmpty(listMap.get(false))) {
            Collections.sort(listMap.get(false), new Comparator<Students>() {
                @Override
                public int compare(Students o1, Students o2) {
                    Students newo1 = new Students();
                    newo1.setName(PinyinUtils.ToPinyinAndGetFirstChar(o1.getName()));
                    Students newo2 = new Students();
                    newo2.setName(PinyinUtils.ToPinyinAndGetFirstChar(o2.getName()));
                    int minLength = newo1.getName().length() < newo2.getName().length() ? newo1.getName().length() : newo2.getName().length();
                    int diff = 0;
                    for (int i=0;i<minLength-1;i++){
                        diff = newo1.getName().substring(i, i+1).compareTo(newo2.getName().substring(i, i+1));
                        if (diff != 0){
                            break;
                        }
                    }
                    return diff;
                }
            });
            students.addAll(listMap.get(false));
        }
        for(Students stu : students){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }
    }
}
