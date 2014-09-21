package yamenko.abcgrocery.views;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import yamenko.abcgrocery.entities.Product;
import yamenko.abcgrocery.views.components.ProductViewComponents;

/**
 *
 * @author Eugene Yamenko <yamenko@me.com>
 */
public class ProductView extends javax.swing.JPanel implements View<ProductViewComponents> {
    private Product product = new Product();
    private ObservableList<Product> products = ObservableCollections.observableList(
            new ArrayList<Product>());

    public Product getProduct() {
        return product;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    @Override
    public Object getComponent(ProductViewComponents component) {
        switch (component) {
            case CreateProductButton:
                return createProductButton;
            case NameFieldBinding:
                return bindingGroup.getBinding("nameField");
            case ProductsTableBinding:
                return bindingGroup.getBinding("productsTable");
            case SalePriceFieldBinding:
                return bindingGroup.getBinding("salePriceField");
            case Product:
                return getProduct();
            case Products:
                return getProducts();
            default:
                return null;
        }
    }

    /**
     * Creates new form ProductView
     */
    public ProductView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new BindingGroup();

        jScrollPane1 = new JScrollPane();
        productTable = new JTable();
        nameField = new JTextField();
        salePriceField = new JTextField();
        createProductButton = new JButton();
        newProductLabel = new JLabel();
        productListLabel = new JLabel();

        setPreferredSize(new Dimension(700, 450));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        productTable.setName("productTable"); // NOI18N
        productTable.getTableHeader().setReorderingAllowed(false);

        ELProperty eLProperty = ELProperty.create("${products}");
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, productTable, "productsTable");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${salePrice}"));
        columnBinding.setColumnName("Sale Price");
        columnBinding.setColumnClass(BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${priceChangedDate}"));
        columnBinding.setColumnName("Price Changed Date");
        columnBinding.setColumnClass(Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(2).setPreferredWidth(20);
            productTable.getColumnModel().getColumn(3).setResizable(false);
            productTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            productTable.getColumnModel().getColumn(4).setResizable(false);
        }

        nameField.setToolTipText("Name");
        nameField.setName("nameField"); // NOI18N

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this, ELProperty.create("${product.name}"), nameField, BeanProperty.create("text"), "nameField");
        bindingGroup.addBinding(binding);

        salePriceField.setToolTipText("Sale price");
        salePriceField.setName("salePriceField"); // NOI18N

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this, ELProperty.create("${product.salePrice}"), salePriceField, BeanProperty.create("text"), "salePriceField");
        bindingGroup.addBinding(binding);

        createProductButton.setText("Create");
        createProductButton.setEnabled(false);
        createProductButton.setName("createProductButton"); // NOI18N

        newProductLabel.setText("Create a new product");
        newProductLabel.setName("newProductLabel"); // NOI18N

        productListLabel.setText("List of the products");
        productListLabel.setName("productListLabel"); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameField)
                        .addComponent(salePriceField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addComponent(createProductButton)
                    .addComponent(newProductLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newProductLabel)
                    .addComponent(productListLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salePriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createProductButton))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton createProductButton;
    public JScrollPane jScrollPane1;
    public JTextField nameField;
    public JLabel newProductLabel;
    public JLabel productListLabel;
    public JTable productTable;
    public JTextField salePriceField;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}