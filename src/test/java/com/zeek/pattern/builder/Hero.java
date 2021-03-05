package com.zeek.pattern.builder;

/**
 * 构建者模式模式
 */
public final class Hero {
  private final String profession;
  private final String name;
  private final String hairType;
  private final String hairColor;
  private final String armor;
  private final String weapon;

  private Hero(HeroBuilder builder) {
    this.profession = builder.profession;
    this.name = builder.name;
    this.hairColor = builder.hairColor;
    this.hairType = builder.hairType;
    this.weapon = builder.weapon;
    this.armor = builder.armor;
  }

  public static class HeroBuilder {
    private final String profession;
    private final String name;
    private String hairType;
    private String hairColor;
    private String armor;
    private String weapon;

    public HeroBuilder(String profession, String name) {
      if (profession == null || name == null) {
        throw new IllegalArgumentException("profession and name can not be null");
      }
      this.profession = profession;
      this.name = name;
    }

    public HeroBuilder withHairType(String hairType) {
      this.hairType = hairType;
      return this;
    }

    public HeroBuilder withHairColor(String hairColor) {
      this.hairColor = hairColor;
      return this;
    }

    public HeroBuilder withArmor(String armor) {
      this.armor = armor;
      return this;
    }

    public HeroBuilder withWeapon(String weapon) {
      this.weapon = weapon;
      return this;
    }

    public Hero build() {
      return new Hero(this);
    }
  }

  public static void main(String[] args) {
    Hero mage = new Hero.
            HeroBuilder("profession", "Riobard").
            withHairColor("BLACK").withWeapon("DAGGER").build();
    System.out.println(mage);
  }
}