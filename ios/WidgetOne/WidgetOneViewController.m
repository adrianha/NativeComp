//
//  WidgetOneViewController.m
//  NativeComp
//
//  Created by adrian.hartanto on 26/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "WidgetOneViewController.h"

@interface WidgetOneViewController ()
@property (strong, nonatomic) WidgetOneViewManager *vm;

@property (weak, nonatomic) IBOutlet UIButton *btnToggle;
@property (weak, nonatomic) IBOutlet UILabel *toggledLabel;

@end

@implementation WidgetOneViewController

- (instancetype)init {
  self = [super initWithNibName:@"WidgetOneViewController" bundle:nil];
  return self;
}

- (instancetype)initWithVM:(WidgetOneViewManager *)vm {
  self = [super init];
  self.vm = vm;
  
  return self;
}

- (void)viewWillAppear:(BOOL)animated {
  [super viewWillAppear:animated];

  [_vm setIntrinsicContentSize:self.view.bounds.size];
}

- (IBAction)onToggle:(UIButton *)sender {
  BOOL shouldShow = _toggledLabel.isHidden;
  [_toggledLabel setHidden:!shouldShow];

  [self.view setNeedsLayout];
  [self.view layoutIfNeeded];

  [_vm setIntrinsicContentSize:self.view.bounds.size];
}

@end
