
public class DateAdder {

    public Date addDays(int year, int month, int day, int addDays){

        if(addDays==0)
            return new Date(year,month,day);

        if(addDays<0)
            return subtractDays(year,month,day,addDays*(-1));

        int monthLength = getMonthLength(year,month);

        if(addDays>(monthLength-day)){
            monthLength-=day;
            addDays -=  monthLength;
            addDays-=1;

            if(month<12)
                month++;
            else{
                month=1;
                year++;
            }

            return addDays(year,month,1,addDays);
        }

        day+=addDays;

        return new Date(year,month,day);
    }

    private Date subtractDays(int year, int month, int day, int minusDays){

        if(minusDays==0)
            return new Date(year,month,day);

        if(day>minusDays){
            day-=minusDays;
            return new Date(year,month,day);
        }

        minusDays-=day;
        month = getPrevMonth(month);
        if(month==12)
            year--;
        int monthLenght = getMonthLength(year,month);

        return subtractDays(year,month,monthLenght,minusDays);
    }

    private int getPrevMonth(int month) {
        if(month>1)
            return month-1;

        return 12;
    }

    private int getMonthLength(int year,int month){

        if(month==1) return 31;

        if(month==2){

            if(isLeapYear(year)){
                return 29;
            }
            else
                return 28;
        }
        if(month==3) return 31;

        if(month==4) return 30;

        if(month==5) return 31;

        if(month==6) return 30;

        if(month==7) return 31;

        if(month==8) return 31;

        if(month==9) return 30;

        if(month==10) return 31;

        if(month==11) return 30;

        if(month==12) return 31;

        return -1;
    }

    private boolean isLeapYear(int year){

        if(year%4==0 && year%100==0 && year%400==0)
            return true;

        return false;

    }

}

class Date{

    public Date(int year,int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int year;
    public int month;
    public int day;

    @Override
    public String toString(){
        return String.valueOf(day)+"." + String.valueOf(month)+"."+String.valueOf(year);
    }

}

