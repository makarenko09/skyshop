package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProducts;
    private final Map<UUID, Article> storageArticles;

    public StorageService() {
        this.storageProducts = new HashMap<>();
        this.storageArticles = new HashMap<>();
        this.dataStorage();
    }

    public Map<UUID, Product> getStorageProducts() {
        return storageProducts;
    }

    public Map<UUID, Article> getStorageArticles() {
        return storageArticles;
    }

    private void dataStorage() {
        Searchable caviar = new DiscountedProduct("Икра красная", 2700, 26);
        Searchable toothStick = new SimpleProduct(12, "Зубная палочка");
        Searchable eggs = new SimpleProduct(200, "упаковка яиц");
        Searchable celery = new FixPriceProduct("Сельдерей упаковка");
        Searchable sauerkraut = new FixPriceProduct("Капуста квашеная");
        Searchable AI = new Article("Искусственный интеллект в медицине", "Искусственный интеллект (ИИ) революционизирует сферу здравоохранения, предоставляя новые инструменты для диагностики, лечения и прогнозирования заболеваний. Данная статья рассматривает текущие применения ИИ в медицине и потенциальные перспективы его развития.");
        Searchable PC = new Article("Квантовые компьютеры: будущее вычислений", "Квантовые компьютеры обещают произвести революцию в мире вычислений, предлагая беспрецедентную вычислительную мощность для решения сложных задач. В этой статье мы исследуем принципы работы квантовых компьютеров и их потенциальное влияние на различные области науки и технологий.");
        Searchable GlobalWarming = new Article("Глобальное потепление: вызовы и решения", "Глобальное потепление представляет собой одну из наиболее серьезных угроз для нашей планеты. Эта статья анализирует текущие тенденции изменения климата, их последствия и предлагает возможные стратегии по смягчению и адаптации к этим изменениям.");
        Searchable Neuroplasticity = new Article("Нейропластичность: как мозг меняется в течение жизни", "Нейропластичность - удивительная способность мозга изменяться и адаптироваться на протяжении всей жизни. В этой статье мы рассмотрим механизмы нейропластичности и их значение для обучения, восстановления после травм и общего когнитивного здоровья.");
        Searchable Blockchain = new Article("Блокчейн: за пределами криптовалют", "Хотя блокчейн наиболее известен как технология, лежащая в основе криптовалют, его потенциал выходит далеко за рамки финансового сектора. Эта статья исследует инновационные применения блокчейна в различных отраслях, от управления цепочками поставок до защиты авторских прав.");
        Searchable GeneticEngineering = new Article("Генная инженерия: этические вопросы и перспективы", "Генная инженерия открывает беспрецедентные возможности для лечения заболеваний и улучшения качества жизни. Однако она также поднимает серьезные этические вопросы. В этой статье мы рассмотрим текущее состояние генной инженерии, ее потенциальные применения и связанные с ней этические дилеммы.");
        Searchable Story = new Article("Крокодил Гена и его друзья", "«Крокодил Гена и его друзья» — детская сказочная повесть Эдуарда Успенского, первое из цикла произведений о Чебурашке и крокодиле Гене.");
        addToProductMap(caviar, toothStick, eggs, celery, sauerkraut, AI, PC, GlobalWarming, Neuroplasticity, Blockchain, GeneticEngineering, Story);
    }

    public Collection<Searchable> getAllStorageValue() {
        List<Searchable> searchableList = new ArrayList<>();
        searchableList.addAll(storageProducts.values());
        searchableList.addAll(storageArticles.values());
        return searchableList;
    }

    public Collection<Product> getAllProductValue() {
        return storageProducts.values();
    }

    public Collection<Article> getAllArticleValue() {
        return storageArticles.values();
    }

    private void addToProductMap(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            String type = searchable.getContentType();
            switch (type) {
                case "PRODUCT":
                    this.storageProducts.put(searchable.getId(), (Product) searchable);
                    break;
                case "ARTICLE":
                    this.storageArticles.put(searchable.getId(), (Article) searchable);
                    break;
            }
        }
    }
}
