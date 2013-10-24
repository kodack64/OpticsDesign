package Optics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Interface.Configable;
import Interface.Drawable;
import MyExtends.ConfigableComponent;
import MyExtends.LabeledComponent;
import MyExtends.MyTextField;

abstract class Optics implements Drawable,Configable,ActionListener,DocumentListener{

	protected OpticsProperty name;
	protected OpticsProperty x;
	protected OpticsProperty y;

	protected ArrayList<LabeledComponent> componentList;
	protected ArrayList<ConfigableComponent> configableComponentList;

	/**
	 * コンストラクタ
	 * @param _name 名前
	 * @param _x X座標
	 * @param _y Y座標
	 */
	public Optics(String _name,Double _x,Double _y){
		componentList = new ArrayList<LabeledComponent>();
		configableComponentList = new ArrayList<ConfigableComponent>();

		name=new OpticsProperty(_name);
		x	=new OpticsProperty(_x);
		y	=new OpticsProperty(_y);

		addObject(name,"Optics Label");
		addObject(x,"Position X");
		addObject(y,"Position Y");
	}

	/**
	 * パラメータオブジェクトを指定
	 * @param obj 指定オブジェクト
	 * @param label ラベル
	 */
	protected void addObject(OpticsProperty obj,String label){
		MyTextField field = new MyTextField(20,label);
		field.getDocument().addDocumentListener(this);
		configableComponentList.add(new ConfigableComponent(obj,label,field));
	}

	/**
	 * 変数の変更をテキストフィールドに反映し、
	 * 操作のためのコンポーネントのリストを返す
	 */
	@Override
	public ArrayList<LabeledComponent> getComponentList() {
		componentList.clear();
		for(int i=0;i<configableComponentList.size();i++){
			ConfigableComponent config = configableComponentList.get(i);
			config.updateField();
			componentList.add(config);
		}
		return componentList;
	}

	/**
	 * テキストフィールドの変更を変数に反映
	 * @param e 変更されたテキストの内容
	 */
	public void textUpdate(DocumentEvent e){
		for(int i=0;i<configableComponentList.size();i++){
			ConfigableComponent config = configableComponentList.get(i);
			if(e.getDocument()==config.field.getDocument()){
				config.updateVariable();
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {textUpdate(e);}
	@Override
	public void removeUpdate(DocumentEvent e) {textUpdate(e);}
	@Override
	public void changedUpdate(DocumentEvent e){textUpdate(e);}
	@Override
	public void actionPerformed(ActionEvent e) {}

}
