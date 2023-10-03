import java.util.ArrayList;
import java.util.List;

public class App {
	abstract static class MobileTariff {
        static int MobileTariffsTotal = 0;

        private String name;
		private int price;
		private int minutes;
		private int gigabytes;

        public MobileTariff(
            String pName,
            int pPrice,
            int pMinutes,
            int pGigabytes
        ) {
            this.name = pName;
            this.price = pPrice;
            this.minutes = pMinutes;
            this.gigabytes = pGigabytes;
            MobileTariffsTotal++;
        }

        public String getName() {
            return this.name;
        }
        public void setName(String newName) {
            this.name = newName;
        }
        public int getPrice() {
            return this.price;
        }
        public void setPrice(int newPrice) {
            this.price = newPrice;
        }
        public int getMinutes() {
            return this.minutes;
        }
        public void setMinutes(int newMinutes) {
            this.minutes = newMinutes;
        }
        public int getGigabytes() {
            return this.gigabytes;
        }
        public void setGigabytes(int newGigabytes) {
            this.gigabytes = newGigabytes;
        }
	}

	public static class FixedTariff extends MobileTariff {
        static int FixedTariffsTotal = 0;
        
        public FixedTariff(
            String pName,
            int pPrice,
            int pMinutes,
            int pGigabytes
        ) {
            super(pName, pPrice, pMinutes, pGigabytes);
            FixedTariffsTotal++;
        }
        
        public String getName() {
            return super.getName();
        }
        public int getPrice() {
            return super.getPrice();
        }
        public int getMinutes() {
            return super.getMinutes();
        }
        public int getGigabytes() {
            return super.getGigabytes();
        }
	}

	public static class CustomizableTariff extends MobileTariff {
        static int CustomizableTariffsTotal = 0;

        public CustomizableTariff(
            String pName,
            int pPrice,
            int pMinutes,
            int pGigabytes
        ) {
            super(pName, pPrice, pMinutes, pGigabytes);
            CustomizableTariffsTotal++;
        }
        
        public String getName() {
            return super.getName();
        }
        public void setName(String newName) {
            super.setName(newName);
        }
        public int getPrice() {
            return super.getPrice();
        }
        public void setPrice(int newPrice) {
            super.setPrice(newPrice);
        }
        public int getMinutes() {
            return super.getMinutes();
        }
        public void setMinutes(int newMinutes) {
            super.setMinutes(newMinutes);
        }
        public int getGigabytes() {
            return super.getGigabytes();
        }
        public void setGigabytes(int newGigabytes) {
            super.setGigabytes(newGigabytes);
        }
	}

    public static class MobileTariffsList {
        private List<MobileTariff> tariffsList = new ArrayList<>();

        public MobileTariffsList(MobileTariff tariff) {
            tariffsList.add(tariff);
        }

        public MobileTariffsList(List<MobileTariff> tariffs) {
            tariffsList = tariffs;
        }

        public void Add(MobileTariff newTariff) {
            tariffsList.add(newTariff);
        }

        public void Show() {
            System.out.println("Список всех тарифов:");
            String result = "";
            for (var tariff : tariffsList) {
                result +=
                    "Название тарифа: " + tariff.name + " " +
                    "Цена: " + tariff.price + " " +
                    "Количество минут: " + tariff.minutes + " " +
                    "Количество гигабайт: " + tariff.gigabytes + "\n";
            }
            System.out.println(result);
        }

        public static void ShowResult(List<MobileTariff> pList) {
            String result = "";
            for (var tariff : pList) {
                result +=
                    "Название тарифа: " + tariff.name + " " +
                    "Цена: " + tariff.price + " " +
                    "Количество минут: " + tariff.minutes + " " +
                    "Количество гигабайт: " + tariff.gigabytes + "\n";
            }
            System.out.println(result);
        }

        // нахождение тарифа по диапазону цены
        public List<MobileTariff> findByPrice(int min, int max) {
            System.out.println("Перечень тарифов по стоимости в диапазоне от " + min + " до " + max + " включительно:");
            List<MobileTariff> result = new ArrayList<>();
            for (var tariff : tariffsList) {
                if (tariff.getPrice() >= min && tariff.getPrice() <= max) {
                    result.add(tariff);
                }
            }
            return result;
        }

        // нахождение тарифа по диапазону минут
        public List<MobileTariff> findByMinutes(int min, int max) {
            System.out.println("Перечень тарифов по количеству минут в диапазоне от " + min + " до " + max + " включительно:");
            List<MobileTariff> result = new ArrayList<>();
            for (var tariff : tariffsList) {
                if (tariff.getMinutes() >= min && tariff.getMinutes() <= max) {
                    result.add(tariff);
                }
            }
            return result;
        }

        // нахождение тарифа по диапазону гигабайтов
        public List<MobileTariff> findByGigabytes(int min, int max) {
            System.out.println("Перечень тарифов по количеству гигабайтов в диапазоне от " + min + " до " + max + " включительно:");
            List<MobileTariff> result = new ArrayList<MobileTariff>();
            for (var tariff : tariffsList) {
                if (tariff.getGigabytes() >= min && tariff.getGigabytes() <= max) {
                    result.add(tariff);
                }
            }
            return result;
        }

        // сортировка по цене тарифа
        public void SortByPrice() {
            List<MobileTariff> sortedTariffsList = tariffsList;
            sortedTariffsList.sort((t1, t2) -> Integer.valueOf(t1.getPrice()).compareTo(Integer.valueOf(t2.getPrice())));
            MobileTariffsList.ShowResult(sortedTariffsList);
        }
    }

    public static void main(String[] args) throws Exception {
        FixedTariff fTariff1 = new FixedTariff("Tariff1", 200, 20, 2);
        FixedTariff fTariff2 = new FixedTariff("Tariff2", 350, 40, 4);
        FixedTariff fTariff3 = new FixedTariff("Tariff3", 700, 150, 15);
        CustomizableTariff cTariff1 = new CustomizableTariff("Example1", 500, 60, 10);
        CustomizableTariff cTariff2 = new CustomizableTariff("Example2", 650, 200, 8);
        
        MobileTariffsList list = new MobileTariffsList(fTariff1);
        list.Add(fTariff2);
        list.Add(fTariff3);
        list.Add(cTariff1);
        list.Add(cTariff2);
        list.Show();

        System.out.println(FixedTariff.FixedTariffsTotal + " фиксированных тарифов");
        System.out.println(CustomizableTariff.CustomizableTariffsTotal + " настраиваемых тарифов");
        System.out.println(MobileTariff.MobileTariffsTotal + " - общее число тарифов");
        System.out.println();

        MobileTariffsList.ShowResult(list.findByPrice(300, 600));
        MobileTariffsList.ShowResult(list.findByMinutes(60, 250));
        MobileTariffsList.ShowResult(list.findByGigabytes(0, 5));

        list.SortByPrice();
    }
}